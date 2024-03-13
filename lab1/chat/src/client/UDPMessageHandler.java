package client;

import utils.Constants;
import utils.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageHandler implements Runnable {
    private final Client client;
    private final DatagramSocket UDPSocket;
    private final byte[] receiveBuffer;

    public UDPMessageHandler(Client client, DatagramSocket UDPSocket) {
        this.client = client;
        this.UDPSocket = UDPSocket;
        this.receiveBuffer = new byte[Constants.BUFFER_SIZE];
    }

    @Override
    public void run() {
        while (client.getRunning().get()) {
            try {
                DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                UDPSocket.receive(packet);
                String receivedMessage = new String(packet.getData()).trim();
                String[] decodedMessage = Message.decodeMessage(receivedMessage);
                String nickname = decodedMessage[1];
                String message = decodedMessage[2];
                System.out.println("(UDP)[" + nickname + "] " + message);
            } catch (IOException ignore) {}
        }
    }
}
