package grpc.server;

import devices.IDevice;
import devices.cameras.NightCamera;
import devices.cameras.PTZCamera;
import devices.cameras.RegularCamera;
import exceptions.*;
import grpc.camera.CameraInfoResponse;
import grpc.camera.CameraServiceGrpc;
import grpc.camera.CameraType;
import grpc.camera.SwitchType;
import io.grpc.Status;

import java.util.Optional;

public class CameraImpl extends CameraServiceGrpc.CameraServiceImplBase {
    private final GrpcServer server;

    public CameraImpl(GrpcServer server) {
        super();
        this.server = server;
    }

    private boolean deviceNotCamera(IDevice device) {
        return !(device instanceof devices.cameras.Camera);
    }

    private boolean isNightVisionCamera(IDevice device) {
        return device instanceof devices.cameras.NightCamera;
    }

    private boolean isPTZCamera(IDevice device) {
        return device instanceof devices.cameras.PTZCamera;
    }

    @Override
    public void cameraSwitch(grpc.camera.SwitchRequest request, io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
        try {
            server.log("Handling camera switch request (" + request.getCameraId() + ")");
            grpc.camera.CameraResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getCameraId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getCameraId() + " not found.");
            } else {
                if (deviceNotCamera(device.get())) {
                    throw new DeviceNotACameraException("Device with id " + request.getCameraId() + " is not a camera.");
                } else {
                    if (request.getSwitchType() == SwitchType.TOGGLE) {
                        response = grpc.camera.CameraResponse.newBuilder().setMessage("Success").build();
                        if (request.getValue()) {
                            device.get().turnOn();
                        } else {
                            device.get().turnOff();
                        }
                    } else {
                        if (isNightVisionCamera(device.get())) {
                            NightCamera camera = (NightCamera) device.get();
                            camera.setNightVision(request.getValue());
                            response = grpc.camera.CameraResponse.newBuilder().setMessage("Success").build();
                        } else {
                            throw new NotANightVisionCameraException("Device with id " + request.getCameraId() + " is not a night vision camera.");
                        }
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotACameraException | DeviceAlreadyOnException | DeviceAlreadyOffException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (NotANightVisionCameraException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void setResolution(grpc.camera.CameraResolutionRequest request, io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
        try {
            server.log("Handling camera resolution change request (" + request.getCameraId() + ")");
            grpc.camera.CameraResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getCameraId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getCameraId() + " not found.");
            } else {
                if (deviceNotCamera(device.get())) {
                    throw new DeviceNotACameraException("Device with id " + request.getCameraId() + " is not a camera.");
                } else {
                    RegularCamera camera = (RegularCamera) device.get();
                    camera.setResolution(request.getResolution());
                    response = grpc.camera.CameraResponse.newBuilder().setMessage("Success").build();
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotACameraException | ResolutionAlreadySetException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void rotate(grpc.camera.CameraRotateRequest request, io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
        try {
            server.log("Handling camera rotation request (" + request.getCameraId() + ")");
            grpc.camera.CameraResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getCameraId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getCameraId() + " not found.");
            } else {
                if (deviceNotCamera(device.get())) {
                    throw new DeviceNotACameraException("Device with id " + request.getCameraId() + " is not a camera.");
                } else {
                    if (isPTZCamera(device.get())) {
                        response = grpc.camera.CameraResponse.newBuilder().setMessage("Success").build();
                        PTZCamera camera = (PTZCamera) device.get();
                        camera.setPan(request.getPan());
                        camera.setTilt(request.getTilt());
                    } else {
                        throw new NotAPTZCameraException("Device with id " + request.getCameraId() + " is not a PTZ camera.");
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotACameraException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (InvalidPanException | InvalidTiltException e) {
            responseObserver.onError(Status.OUT_OF_RANGE.withDescription(e.getMessage()).asRuntimeException());
        } catch (NotAPTZCameraException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void zoom(grpc.camera.CameraZoomRequest request, io.grpc.stub.StreamObserver<grpc.camera.CameraResponse> responseObserver) {
        try {
            server.log("Handling zoom request (" + request.getCameraId() + ")");
            grpc.camera.CameraResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getCameraId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getCameraId() + " not found.");
            } else {
                if (deviceNotCamera(device.get())) {
                    throw new DeviceNotACameraException("Device with id " + request.getCameraId() + " is not a camera.");
                } else {
                    if (isPTZCamera(device.get())) {
                        response = grpc.camera.CameraResponse.newBuilder().setMessage("Success").build();
                        PTZCamera camera = (PTZCamera) device.get();
                        camera.setZoom(request.getZoom());
                    } else {
                        throw new NotAPTZCameraException("Device with id " + request.getCameraId() + " is not a PTZ camera.");
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotACameraException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (NotAPTZCameraException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(e.getMessage()).asRuntimeException());
        } catch (InvalidZoomException e) {
            responseObserver.onError(Status.OUT_OF_RANGE.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getInfo(grpc.camera.CameraInfoRequest request, io.grpc.stub.StreamObserver<grpc.camera.CameraInfoResponse> responseObserver) {
        try {
            server.log("Handling camera information request (" + request.getCameraId() + ")");
            grpc.camera.CameraInfoResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getCameraId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getCameraId() + " not found.");
            } else {
                if (deviceNotCamera(device.get())) {
                    throw new DeviceNotACameraException("Device with id " + request.getCameraId() + " is not a camera.");
                } else {
                    CameraInfoResponse.Builder builder = CameraInfoResponse.newBuilder().setCameraId(request.getCameraId());
                    CameraType type = null;
                    if (isNightVisionCamera(device.get())) {
                        NightCamera camera = (NightCamera) device.get();
                        builder.setIsNightModeOn(camera.isNightVisionOn());
                        type = CameraType.NIGHT;
                    }
                    if (isPTZCamera(device.get())) {
                        PTZCamera camera = (PTZCamera) device.get();
                        builder.setPan(camera.getPan()).setTilt(camera.getTilt()).setZoom(camera.getZoom());
                        if (type == null) {
                            type = CameraType.PTZ;
                        }
                    }
                    if (type == null) {
                        type = CameraType.REGULAR;
                    }
                    RegularCamera camera = (RegularCamera) device.get();
                    response = builder.setType(type).setIsOn(camera.isOn()).setResolution(camera.getResolution()).build();
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotACameraException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
