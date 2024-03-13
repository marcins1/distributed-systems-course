package client;

public class ClientShutdownHook implements Runnable {
    Client client;

    public ClientShutdownHook(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        client.stop();
    }
}
