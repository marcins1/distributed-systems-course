package grpc.server;

import devices.IDevice;
import grpc.server_info.DevicesInfoRequest;
import grpc.server_info.DevicesInfoResponse;
import grpc.server_info.InfoServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class InfoImpl extends InfoServiceGrpc.InfoServiceImplBase {
    private final GrpcServer server;

    public InfoImpl(GrpcServer server) {
        super();
        this.server = server;
    }

    @Override
    public void getInfo(DevicesInfoRequest request, StreamObserver<DevicesInfoResponse> responseObserver) {
        try {
            server.log("Handling device information request");
            grpc.server_info.DevicesInfoResponse response;
            List<IDevice> devices = server.getDevices();
            List<String> ids = new ArrayList<>();
            for (IDevice device : devices) {
                ids.add(device.getId());
            }
            response = grpc.server_info.DevicesInfoResponse.newBuilder().addAllDevices(ids).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
