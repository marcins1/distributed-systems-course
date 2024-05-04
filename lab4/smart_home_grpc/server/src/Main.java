import devices.IDevice;
import devices.cameras.NightCamera;
import devices.cameras.PTZCamera;
import devices.cameras.RegularCamera;
import devices.fridges.Fridge;
import devices.lamps.BrightnessLamp;
import devices.lamps.OnOffLamp;
import grpc.server.GrpcServer;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        List<IDevice> devices = List.of(
//            new Fridge("fridge1"),
//            new RegularCamera("camera1"),
//            new Fridge("fridge2"),
//            new OnOffLamp("lamp1"),
//            new OnOffLamp("lamp2"),
//            new BrightnessLamp("lamp3")
//        );
//        String serverName = "SERVER1";
//        int port = 50051;

        List<IDevice> devices = List.of(
            new PTZCamera("camera1"),
            new PTZCamera("camera2"),
            new NightCamera("camera3"),
            new NightCamera("camera4"),
            new RegularCamera("camera5"),
            new RegularCamera("camera6")
        );
        String serverName = "SERVER2";
        int port = 50052;

        GrpcServer server = new GrpcServer(serverName, port, devices);
        try {
            server.run();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}