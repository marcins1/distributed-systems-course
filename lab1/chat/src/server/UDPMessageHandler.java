package server;

import utils.Constants;
import utils.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageHandler implements Runnable {
    private final Server server;
    private final DatagramSocket socket;
    byte[] receiveBuffer;

    public UDPMessageHandler(Server server, DatagramSocket socket) {
        this.server = server;
        this.socket = socket;
        this.receiveBuffer = new byte[Constants.BUFFER_SIZE];
    }

    @Override
    public void run() {
        while (server.getRunning().get()) {
            try {
                DatagramPacket receivedPacket = new DatagramPacket(receiveBuffer, Constants.BUFFER_SIZE);
                socket.receive(receivedPacket);
                messageParser(receivedPacket);
            } catch (Exception ignore) {}
        }
    }

    private void messageParser(DatagramPacket packet) throws IOException {
        String message = new String(packet.getData()).trim();
        String[] decodedMessage = Message.decodeMessage(message);
        String command = decodedMessage[0];
        String nickname = decodedMessage[1];
        switch (command) {
            case Constants.UDP_CONNECT_COMMAND -> {
                server.addUDPClient(packet.getAddress(), packet.getPort(), nickname);
            }
            case Constants.UDP_MESSAGE_COMMAND -> {
                server.sendUDPMessageToAllExceptOne(message, nickname);
            }
            default -> {}
        }
    }
}
