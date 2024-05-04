import grpc
import logging
import fridge_commands
import lamp_commands
import camera_commands

from gen import serverInfo_pb2
from gen import serverInfo_pb2_grpc


class Client(object):
    def __init__(self):
        self.names = ['s1', 's2']
        self.hosts = ['localhost', 'localhost']
        self.server_ports = [50051, 50052]
        self.channels = [grpc.insecure_channel('{}:{}'.format(self.hosts[i], self.server_ports[i])) for i in range(len(self.names))]
        self.server_stubs = [serverInfo_pb2_grpc.InfoServiceStub(channel) for channel in self.channels]
        self.fridge_handler = fridge_commands.FridgeCommands(self.names, self.channels)
        self.lamp_handler = lamp_commands.LampCommands(self.names, self.channels)
        self.camera_handler = camera_commands.CameraCommands(self.names, self.channels)

    @staticmethod
    def print_available_devices(response):
        print("Server response:")
        print("Available devices:")
        for device in response.devices:
            print(device)

    def get_info(self, server):
        try:
            server_index = self.names.index(server)
            request = serverInfo_pb2.DevicesInfoRequest()
            response = self.server_stubs[server_index].GetInfo(request)
            self.print_available_devices(response)
        except Exception as e:
            print("Error received from server:")
            print(e)

    def print_possible_commands(self):
        print('Available servers:')
        for name in self.names:
            print(name)
        print('Possible commands:')
        print('<server> info                                                                              - Server informations about available devices')
        print('<server> f_toggle <id> <type(0-fridge, rest-freezer)> <value(0-turn off, rest-turn on)>    - Toggle fridge or freezer')
        print('<server> f_temp <id> <type(0-fridge, rest-freezer)> <value(int)>                           - Set temperature for fridge or freezer')
        print('<server> f_info <id>                                                                       - Fridge informations')
        print('<server> l_set <id> <value>                                                                - Set lamp value')
        print('<server> l_info <id>                                                                       - Lamp informations')
        print('<server> c_toggle <id> <type(0-toggle, rest-night mode)> <value(0-turn off, rest-turn on)> - Switch camera')
        print('<server> c_res <id> <resolution(0-480p, 1-720p, rest-1080p)>                               - Set camera resolution')
        print('<server> c_rotate <id> <pan(int)> <tilt(int)>                                              - Rotate camera')
        print('<server> c_zoom <id> <zoom>                                                                - Zoom camera')
        print('<server> c_info <id>                                                                       - Camera informations')

    def parse_command(self, command):
        command = command.split(' ')
        if len(command) > 1:
            server = command[0]
            if server not in self.names:
                print('Server name not found')
                return
            option = command[1]
            arguments = command[2:]
            if option == 'info':
                self.get_info(server)
            elif option == 'f_info':
                self.fridge_handler.get_fridge_info(server, arguments)
            elif option == 'f_temp':
                self.fridge_handler.set_temperature(server, arguments)
            elif option == 'f_toggle':
                self.fridge_handler.toggle_fridge(server, arguments)
            elif option == 'l_set':
                self.lamp_handler.set_lamp(server, arguments)
            elif option == 'l_info':
                self.lamp_handler.get_lamp_info(server, arguments)
            elif option == 'c_toggle':
                self.camera_handler.switch_camera(server, arguments)
            elif option == 'c_res':
                self.camera_handler.set_resolution(server, arguments)
            elif option == 'c_rotate':
                self.camera_handler.rotate(server, arguments)
            elif option == 'c_zoom':
                self.camera_handler.zoom(server, arguments)
            elif option == 'c_info':
                self.camera_handler.camera_info(server, arguments)
            else:
                print('Unknown command')
        else:
            print('Invalid command')
        print()

    def run(self):
        self.print_possible_commands()
        while True:
            command = input('Enter command: ')
            if command == 'exit':
                break
            self.parse_command(command)


def main():
    client = Client()
    client.run()
    print('Client closed')


if __name__ == "__main__":
    logging.basicConfig()
    main()
