package grpc.server;

import devices.IDevice;
import devices.fridges.Fridge;
import exceptions.*;
import grpc.fridge.ChamberType;
import grpc.fridge.FridgeInfoRequest;
import grpc.fridge.FridgeInfoResponse;
import grpc.fridge.FridgeServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.Optional;

public class FridgeImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private final GrpcServer server;

    public FridgeImpl(GrpcServer server) {
        super();
        this.server = server;
    }

    private boolean deviceNotFridge(IDevice device) {
        return !(device instanceof devices.fridges.Fridge);
    }

    @Override
    public void setTemperature(grpc.fridge.FridgeTemperatureRequest request, io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse> responseObserver) {
        try {
            server.log("Handling fridge set temperature request (" + request.getId() + ")");
            grpc.fridge.FridgeResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getId() + " not found.");
            } else {
                if (deviceNotFridge(device.get())) {
                    throw new DeviceNotAFridgeException("Device with id " + request.getId() + " is not a fridge.");
                } else {
                    response = grpc.fridge.FridgeResponse.newBuilder().setMessage("Success").build();
                    Fridge fridge = (Fridge) device.get();
                    if (request.getType().equals(ChamberType.FREEZER)) {
                        fridge.setFreezerTemperature(request.getValue());
                    } else {
                        fridge.setFridgeTemperature(request.getValue());
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotAFridgeException | InvalidFreezerTemperatureException | InvalidFridgeTemperatureException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void setPower(grpc.fridge.FridgeToggleRequest request, io.grpc.stub.StreamObserver<grpc.fridge.FridgeResponse> responseObserver) {
        try {
            server.log("Handling fridge set power request (" + request.getId() + ")");
            grpc.fridge.FridgeResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getId() + " not found.");
            } else {
                if (deviceNotFridge(device.get())) {
                    throw new DeviceNotAFridgeException("Device with id " + request.getId() + " is not a fridge.");
                } else {
                    response = grpc.fridge.FridgeResponse.newBuilder().setMessage("Success").build();
                    Fridge fridge = (Fridge) device.get();
                    if (request.getType().equals(ChamberType.FREEZER)) {
                        if (request.getValue()) {
                            fridge.turnFreezerOn();
                        } else {
                            fridge.turnFreezerOff();
                        }
                    } else {
                        if (request.getValue()) {
                            fridge.turnOn();
                        } else {
                            fridge.turnOff();
                        }
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotAFridgeException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceAlreadyOnException | DeviceAlreadyOffException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getInfo(FridgeInfoRequest request, StreamObserver<FridgeInfoResponse> responseObserver) {
        try {
            server.log("Handling fridge information request (" + request.getId() + ")");
            grpc.fridge.FridgeInfoResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getId() + " not found.");
            } else {
                if (deviceNotFridge(device.get())) {
                    throw new DeviceNotAFridgeException("Device with id " + request.getId() + " is not a fridge.");
                } else {
                    Fridge fridge = (Fridge) device.get();
                    response = FridgeInfoResponse.newBuilder().setId(request.getId()).setFridgeOn(fridge.isOn()).setFreezerOn(fridge.isFreezerOn()).setFridgeTemperature(fridge.getFridgeTemperature()).setFreezerTemperature(fridge.getFreezerTemperature()).build();
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotAFridgeException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
