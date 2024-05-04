from gen import camera_pb2
from gen import camera_pb2_grpc


class CameraCommands(object):
    def __init__(self, server_names, channels):
        self.names = server_names
        self.camera_stubs = [camera_pb2_grpc.CameraServiceStub(channel) for channel in channels]

    @staticmethod
    def print_camera_info(response):
        print(f"Server response:")
        print(f"camera_id: {response.camera_id}")
        print(f"is_on: {response.is_on}")
        print(f"resolution: {camera_pb2.CameraResolution.Name(response.resolution)}")
        print(f"type: {camera_pb2.CameraType.Name(response.type)}")
        if response.type == camera_pb2.CameraType.NIGHT:
            print(f"is_night_mode_on: {response.is_night_mode_on}")
        if response.type == camera_pb2.CameraType.PTZ:
            print(f"pan: {response.pan}")
            print(f"tilt: {response.tilt}")
            print(f"zoom: {response.zoom}")

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

    def switch_camera(self, server, args):
        if len(args) != 3:
            print("Invalid number of arguments")
            return
        if args[1] == "0":
            args[1] = camera_pb2.SwitchType.TOGGLE
        else:
            args[1] = camera_pb2.SwitchType.NIGHT_MODE
        if args[2] == "0":
            args[2] = False
        else:
            args[2] = True
        try:
            request = camera_pb2.SwitchRequest(camera_id=args[0], switch_type=args[1], value=args[2])
            response = self.camera_stubs[self.get_server_index(server)].CameraSwitch(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def set_resolution(self, server, args):
        if len(args) != 2:
            print("Invalid number of arguments")
            return
        if args[1] == "0":
            args[1] = camera_pb2.CameraResolution.RESOLUTION_480P
        elif args[1] == "1":
            args[1] = camera_pb2.CameraResolution.RESOLUTION_720P
        else:
            args[1] = camera_pb2.CameraResolution.RESOLUTION_1080P
        try:
            request = camera_pb2.CameraResolutionRequest(camera_id=args[0], resolution=args[1])
            response = self.camera_stubs[self.get_server_index(server)].SetResolution(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def rotate(self, server, args):
        if len(args) != 3:
            print("Invalid number of arguments")
            return
        try:
            args[1] = int(args[1])
            args[2] = int(args[2])
        except ValueError:
            print("Provided invalid value")
            return
        try:
            request = camera_pb2.CameraRotateRequest(camera_id=args[0], pan=args[1], tilt=args[2])
            response = self.camera_stubs[self.get_server_index(server)].Rotate(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def zoom(self, server, args):
        if len(args) != 2:
            print("Invalid number of arguments")
            return
        try:
            args[1] = int(args[1])
        except ValueError:
            print("Provided invalid value")
            return
        try:
            request = camera_pb2.CameraZoomRequest(camera_id=args[0], zoom=args[1])
            response = self.camera_stubs[self.get_server_index(server)].Zoom(request)
            self.print_default_response(response)
        except Exception as e:
            self.print_error(e)

    def camera_info(self, server, args):
        if len(args) != 1:
            print("Invalid number of arguments")
            return
        try:
            request = camera_pb2.CameraInfoRequest(camera_id=args[0])
            response = self.camera_stubs[self.get_server_index(server)].GetInfo(request)
            self.print_camera_info(response)
        except Exception as e:
            self.print_error(e)
