from gen import lamp_pb2
from gen import lamp_pb2_grpc


class LampCommands(object):
    def __init__(self, server_names, channels):
        self.names = server_names
        self.lamp_stubs = [lamp_pb2_grpc.LampServiceStub(channel) for channel in channels]

    @staticmethod
    def print_lamp_info(response):
        print(f"Server response:")
        print(f"id: {response.id}")
        print(f"type: {lamp_pb2.LampType.Name(response.type)}")
        print(f"value: {response.value}")

    @staticmethod
    def print_default_response(response):
        print(f"Server response:")
        print(f"message: {response.message}")

    @staticmethod
    def print_error(error):
        print("Error received from server:")
        print(error)

    def get_server_index(self, server):
        return self.names.index(server)

    def set_lamp(self, server, args):
        if len(args) != 2:
            print("Invalid number of arguments")
            return
        try:
            args[1] = int(args[1])
        except ValueError:
            print("Provided invalid value")
            return
        try:
            request = lamp_pb2.LampRequest(id=args[0], value=args[1])
            response = self.lamp_stubs[self.get_server_index(server)].SetLamp(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def get_lamp_info(self, server, args):
        if len(args) != 1:
            print("Invalid number of arguments")
            return
        try:
            request = lamp_pb2.LampInfoRequest(id=args[0])
            response = self.lamp_stubs[self.get_server_index(server)].GetInfo(request)
            self.print_lamp_info(response)
        except Exception as e:
            self.print_error(e)
