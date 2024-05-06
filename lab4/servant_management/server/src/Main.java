import ice.server.IceServer;

public class Main {
    public static void main(String[] args) {
        IceServer server = new IceServer(args, "CalculatorServer");
        server.run();
    }
}