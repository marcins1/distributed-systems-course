package grpc.server;

import devices.IDevice;
import devices.lamps.BrightnessLamp;
import devices.lamps.OnOffLamp;
import exceptions.*;
import grpc.lamp.LampInfoRequest;
import grpc.lamp.LampInfoResponse;
import grpc.lamp.LampServiceGrpc;
import grpc.lamp.LampType;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.Optional;

public class LampImpl extends LampServiceGrpc.LampServiceImplBase {
    private final GrpcServer server;

    public LampImpl(GrpcServer server) {
        super();
        this.server = server;
    }

    private boolean deviceNotLamp(IDevice device) {
        return !(device instanceof devices.lamps.Lamp);
    }

    @Override
    public void setLamp(grpc.lamp.LampRequest request, io.grpc.stub.StreamObserver<grpc.lamp.LampResponse> responseObserver) {
        try {
            server.log("Handling lamp set request (" + request.getId() + ")");
            grpc.lamp.LampResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getId() + " not found.");
            } else {
                if (deviceNotLamp(device.get())) {
                    throw new DeviceNotALampException("Device with id " + request.getId() + " is not a lamp.");
                } else {
                    response = grpc.lamp.LampResponse.newBuilder().setMessage("Success").build();
                    if (device.get() instanceof OnOffLamp lamp) {
                        if (request.getValue() > 0) {
                            lamp.turnOn();
                        } else {
                            lamp.turnOff();
                        }
                    } else {
                        BrightnessLamp lamp = (BrightnessLamp) device.get();
                        lamp.setBrightness(request.getValue());
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotALampException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceAlreadyOnException | DeviceAlreadyOffException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(e.getMessage()).asRuntimeException());
        } catch (InvalidBrightnessException e) {
            responseObserver.onError(Status.OUT_OF_RANGE.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getInfo(LampInfoRequest request, StreamObserver<LampInfoResponse> responseObserver) {
        try {
            server.log("Handling lamp information request (" + request.getId() + ")");
            grpc.lamp.LampInfoResponse response;
            Optional<IDevice> device = server.getDeviceById(request.getId());
            if (device.isEmpty()) {
                throw new DeviceNotFoundException("Device with id " + request.getId() + " not found.");
            } else {
                if (deviceNotLamp(device.get())) {
                    throw new DeviceNotALampException("Device with id " + request.getId() + " is not a lamp.");
                } else {
                    if (device.get() instanceof OnOffLamp lamp) {
                        int value = lamp.isOn() ? 1 : 0;
                        response = grpc.lamp.LampInfoResponse.newBuilder().setId(request.getId()).setType(LampType.ON_OFF).setValue(value).build();
                    } else {
                        BrightnessLamp lamp = (BrightnessLamp) device.get();
                        response = grpc.lamp.LampInfoResponse.newBuilder().setId(request.getId()).setType(LampType.BRIGHTNESS).setValue(lamp.getBrightness()).build();
                    }
                }
            }
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (DeviceNotFoundException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        } catch (DeviceNotALampException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
