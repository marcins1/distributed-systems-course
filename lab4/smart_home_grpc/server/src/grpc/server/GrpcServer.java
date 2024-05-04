package grpc.server;

import devices.IDevice;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;

public class GrpcServer {
    private final String name;
    private final int port;
    private Server server;
    private final List<IDevice> devices;

    public GrpcServer(String name, int port, List<IDevice> devices) {
        this.name = name;
        this.port = port;
        this.devices = devices;
    }

    public void start() throws IOException {
        server = ServerBuilder.forPort(this.port).executor((Executors.newFixedThreadPool(8)))
                .addService(new InfoImpl(this))
                .addService(new FridgeImpl(this))
                .addService(new LampImpl(this))
                .addService(new CameraImpl(this))
                .build()
                .start();
        log("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log("Shutting down gRPC server...");
            stop();
            log("Server shut down.");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void log(String message) {
        System.out.println("[" + this.name + "] " + message);
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public void run() throws IOException, InterruptedException {
        this.start();
        this.blockUntilShutdown();
    }

    public synchronized Optional<IDevice> getDeviceById(String id) {
        for (IDevice device : devices) {
            if (device.getId().equals(id)) {
                return Optional.of(device);
            }
        }
        return Optional.empty();
    }

    public synchronized List<IDevice> getDevices() {
        return devices;
    }
}
