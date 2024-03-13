package server;

import utils.Constants;
import utils.Message;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server implements Runnable {
    private ServerSocket TCPSocket;
    private DatagramSocket UDPSocket;
    private final AtomicBoolean running;
    private final ArrayList<TCPClientHandler> TCPClients;
    private final ArrayList<UDPClientHandler> UDPClients;
    private final ExecutorService threadPool;

    public Server() {
        TCPClients = new ArrayList<>();
        UDPClients = new ArrayList<>();
        threadPool = Executors.newCachedThreadPool();
        running = new AtomicBoolean(true);
    }

    public void run() {
        try {
            initializeSockets();
            serverLog("Server started on port " + Constants.PORT);
            startServerThreads();
            addShutdownHook();

            mainLoop();
        } catch (Exception ignore) {
        } finally {
            stop();
        }
    }

    private void initializeSockets() throws IOException {
        TCPSocket = new ServerSocket(Constants.PORT);
        UDPSocket = new DatagramSocket(Constants.PORT);
    }

    private void startServerThreads() {
        new Thread(new UDPMessageHandler(this, UDPSocket)).start();
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new ServerShutdownHook(this)));
    }

    private void mainLoop() throws IOException {
        while (running.get()) {
            Socket newClientSocket = TCPSocket.accept();
            TCPClientHandler newClient = new TCPClientHandler(this, newClientSocket);
            addTCPClient(newClient);
            threadPool.execute(newClient);
        }
    }

    public void serverLog(String message) {
        System.out.println("[SERVER] " + message);
    }

    public synchronized boolean nicknameAvailable(String nickname) {
        if (nickname.equals(Constants.DEFAULT_USERNAME) || nickname.equals(Constants.SERVER_NAME)) {
            return false;
        }
        for (TCPClientHandler client : TCPClients) {
            if (client.getNickname().equals(nickname)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void toAll(String message) {
        for (TCPClientHandler client : TCPClients) {
            client.getOutputStream().println(message);
        }
    }

    public synchronized void toAllExceptOne(String message, String sender) {
        for (TCPClientHandler client : TCPClients) {
            if (!client.getNickname().equals(sender)) {
                client.getOutputStream().println(message);
            }
        }
    }

    public synchronized void addTCPClient(TCPClientHandler client) {
        TCPClients.add(client);
    }

    public synchronized void removeTCPClient(TCPClientHandler client) {
        TCPClients.remove(client);
    }

    public synchronized void closeTCPClient(TCPClientHandler client) {
        client.close();
    }

    private synchronized boolean clientExists(String nickname) {
        for (TCPClientHandler client : TCPClients) {
            if (client.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void addUDPClient(InetAddress address, int port, String nickname) {
        if (clientExists(nickname)) {
            UDPClients.add(new UDPClientHandler(address, port, nickname));
        }
    }

    public synchronized void sendUDPMessageToAllExceptOne(String data, String nickname) throws IOException {
        byte[] sendBuffer = data.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length);
        for (UDPClientHandler client : UDPClients) {
            if (!client.nickname().equals(nickname)) {
                sendPacket.setAddress(client.address());
                sendPacket.setPort(client.port());
                UDPSocket.send(sendPacket);
            }
        }
    }

    public synchronized void removeUDPClient(String nickname) {
        for (UDPClientHandler client : UDPClients) {
            if (client.nickname().equals(nickname)) {
                UDPClients.remove(client);
                return;
            }
        }
    }

    public void stop() {
        serverLog("Shutting down...");
        running.set(false);
        toAll(Message.buildMessage(Constants.LEAVE_COMMAND, Constants.SERVER_NAME, "."));
        ArrayList<TCPClientHandler> clientsCopy = new ArrayList<>(TCPClients);
        for (TCPClientHandler client : clientsCopy) {
            closeTCPClient(client);
        }
        threadPool.shutdown();
        try {
            if (TCPSocket != null && !TCPSocket.isClosed()){
                TCPSocket.close();
            }
            if (UDPSocket != null && !UDPSocket.isClosed()){
                UDPSocket.close();
            }
        } catch (IOException ignore) {}
    }

    public AtomicBoolean getRunning() {
        return running;
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
