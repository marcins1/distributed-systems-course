package client;

import utils.Constants;
import utils.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class MulticastMessageHandler implements Runnable {
    private final Client client;
    private final MulticastSocket multicastSocket;
    private final byte[] receiveBuffer;

    public MulticastMessageHandler(Client client, MulticastSocket multicastSocket) {
        this.client = client;
        this.multicastSocket = multicastSocket;
        this.receiveBuffer = new byte[Constants.BUFFER_SIZE];
    }

    @Override
    public void run() {
        while (client.getRunning().get()) {
            try {
                DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                multicastSocket.receive(packet);
                String receivedMessage = new String(packet.getData()).trim();
                String[] decodedMessage = Message.decodeMessage(receivedMessage);
                String nickname = decodedMessage[1];
                String message = decodedMessage[2];
                System.out.println("(Multicast)[" + nickname + "] " + message);
            } catch (IOException ignore) {}
        }
    }
}
