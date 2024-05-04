from gen import fridge_pb2
from gen import fridge_pb2_grpc


class FridgeCommands(object):
    def __init__(self, server_names, channels):
        self.names = server_names
        self.fridge_stubs = [fridge_pb2_grpc.FridgeServiceStub(channel) for channel in channels]

    @staticmethod
    def print_fridge_info(response):
        print(f"Server response:")
        print(f"id: {response.id}")
        print(f"freezerOn: {response.freezerOn}")
        print(f"fridgeOn: {response.fridgeOn}")
        print(f"freezerTemperature: {response.freezerTemperature}")
        print(f"fridgeTemperature: {response.fridgeTemperature}")

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

    def set_temperature(self, server, args):
        if len(args) != 3:
            print("Invalid number of arguments")
            return
        try:
            args[2] = int(args[2])
        except ValueError:
            print("Provided invalid value")
            return
        if args[1] == "0":
            args[1] = fridge_pb2.ChamberType.FRIDGE
        else:
            args[1] = fridge_pb2.ChamberType.FREEZER
        try:
            request = fridge_pb2.FridgeTemperatureRequest(id=args[0], type=args[1], value=args[2])
            response = self.fridge_stubs[self.get_server_index(server)].SetTemperature(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def toggle_fridge(self, server, args):
        if len(args) != 3:
            print("Invalid number of arguments")
            return
        if args[1] == "0":
            args[1] = fridge_pb2.ChamberType.FRIDGE
        else:
            args[1] = fridge_pb2.ChamberType.FREEZER

        if args[2] == "0":
            args[2] = False
        else:
            args[2] = True
        try:
            request = fridge_pb2.FridgeToggleRequest(id=args[0], type=args[1], value=args[2])
            response = self.fridge_stubs[self.get_server_index(server)].SetPower(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def get_fridge_info(self, server, args):
        if len(args) != 1:
            print("Invalid number of arguments")
            return
        try:
            request = fridge_pb2.FridgeInfoRequest(id=args[0])
            response = self.fridge_stubs[self.get_server_index(server)].GetInfo(request)
            self.print_fridge_info(response)
        except Exception as e:
            self.print_error(e)