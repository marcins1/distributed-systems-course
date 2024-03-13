package client;

import utils.Constants;
import utils.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client implements Runnable {
    private Socket TCPSocket;
    private DatagramSocket UDPSocket;
    private MulticastSocket multicastSocket;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final AtomicBoolean leavingMessageSent = new AtomicBoolean(false);
    private final AtomicBoolean settingNickname = new AtomicBoolean(true);
    private String nickname = Constants.DEFAULT_USERNAME;
    private PrintWriter output;
    private BufferedReader input;

    public void run() {
        try {
            initializeSockets();
            addShutdownHook();
            initializeStreams();
            startClientThreads();
            mainLoop();
        } catch (Exception ignore) {
        } finally {
            if (running.get()) {
                stop();
            }
        }
    }

    private void initializeSockets() throws IOException {
        TCPSocket = new Socket(Constants.HOST, Constants.PORT);
        UDPSocket = new DatagramSocket();
        multicastSocket = new MulticastSocket(Constants.MULTICAST_PORT);
        multicastSocket.joinGroup(InetAddress.getByName(Constants.MULTICAST_ADDRESS));
    }

    private void initializeStreams() throws IOException {
        output = new PrintWriter(TCPSocket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(TCPSocket.getInputStream()));
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new ClientShutdownHook(this)));
    }

    private void startClientThreads() {
        InputHandler clientInputHandler = new InputHandler(this, output);

        new Thread(clientInputHandler).start();
        new Thread(new UDPMessageHandler(this, UDPSocket)).start();
        new Thread(new MulticastMessageHandler(this, multicastSocket)).start();
    }

    private void mainLoop() throws IOException {
        while (running.get()) {
            // Read messages from the server
            String message = input.readLine();
            parseMessage(message);
        }
    }

    private void parseMessage(String message) throws IOException {
        String[] decodedMessage = Message.decodeMessage(message);
        switch (decodedMessage[0]) {
            case Constants.LEAVE_COMMAND -> {
                leavingMessageSent.set(true);
                stop();
                System.out.println("Connection closed by the server. Press enter to exit.");
            }
            case Constants.SET_NICKNAME_COMMAND -> {
                System.out.println("[" + decodedMessage[1] + "] " + decodedMessage[2]);
                settingNickname.set(false);
                nickname = decodedMessage[1];
                connectViaUDP();
            }
            case Constants.CHAT_MESSAGE_COMMAND, Constants.SETTING_NICKNAME_COMMAND ->
                    System.out.println("[" + decodedMessage[1] + "] " + decodedMessage[2]);
            default ->
                System.out.println("Unknown command received");
        }
    }

    private void connectViaUDP() throws IOException {
        String message = Message.buildMessage(Constants.UDP_CONNECT_COMMAND, nickname, ".");
        sendUDPMessage(message);
    }

    public void sendUDPMessage(String data) throws IOException {
        byte[] sendBuffer = data.getBytes();
        InetAddress address = InetAddress.getByName(Constants.HOST);
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, Constants.PORT);
        UDPSocket.send(sendPacket);
    }

    public void sendMulticastMessage(String data) throws IOException {
        byte[] sendBuffer = data.getBytes();
        InetAddress address = InetAddress.getByName(Constants.MULTICAST_ADDRESS);
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, Constants.MULTICAST_PORT);
        multicastSocket.send(sendPacket);
    }

    public void stop() {
        if (!leavingMessageSent.get()) {
            if (output != null) {
                output.println(Message.buildMessage(Constants.LEAVE_COMMAND, nickname, "."));
            }
            leavingMessageSent.set(true);
        }
        running.set(false);
        try {
            if (output != null) {
                output.close();
            }
            if (input != null) {
                input.close();
            }
            if (TCPSocket != null && !TCPSocket.isClosed()) {
                TCPSocket.close();
            }
            if (UDPSocket != null && !UDPSocket.isClosed()) {
                UDPSocket.close();
            }
            if (multicastSocket != null && !multicastSocket.isClosed()) {
                multicastSocket.close();
            }
        } catch (Exception ignore) {}
    }

    public AtomicBoolean getRunning() {
        return running;
    }

    public String getNickname() {
        return nickname;
    }

    public AtomicBoolean isSettingNickname() {
        return settingNickname;
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
