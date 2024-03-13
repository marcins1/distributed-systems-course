package server;

import utils.Constants;
import utils.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class TCPClientHandler implements Runnable {
    private final Server server;
    private final Socket socket;
    private PrintWriter output;
    private BufferedReader input;
    private String nickname;
    AtomicBoolean running;

    public TCPClientHandler(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.nickname = Constants.DEFAULT_USERNAME;
        this.running = new AtomicBoolean(true);
    }

    public void run() {
        try {
            initializeStreams();
            server.serverLog("New client connected");
            setClientNickname();
            String message;
            while(running.get() && (message = input.readLine()) != null) {
                parseMessage(message);
            }
        } catch (IOException ignore) {
        } finally {
            close();
        }
    }

    private void initializeStreams() throws IOException {
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void setClientNickname() throws IOException {
        output.println(Message.buildMessage(Constants.SETTING_NICKNAME_COMMAND, Constants.SERVER_NAME, "Welcome to the chat server! Please enter your nickname:"));
        String message = input.readLine();
        String newNickname = Message.decodeMessage(message)[2];
        if (newNickname.equals(Constants.LEAVE_COMMAND)) {
            String leaveMessage = Message.buildMessage(Constants.LEAVE_COMMAND, Constants.SERVER_NAME, ".");
            output.println(leaveMessage);
            close();
            return;
        }
        while (!server.nicknameAvailable(newNickname)) {
            output.println(Message.buildMessage(Constants.SETTING_NICKNAME_COMMAND, Constants.SERVER_NAME, "Nickname unavailable. Please enter a different nickname:"));
            newNickname = Message.decodeMessage(input.readLine())[2];
            if (newNickname.equals(Constants.LEAVE_COMMAND)) {
                output.println(Constants.LEAVE_COMMAND);
                close();
                return;
            }
        }
        nickname = newNickname;
        output.println(Message.buildMessage(Constants.SET_NICKNAME_COMMAND, nickname, "Nickname set to: " + nickname));
        server.toAllExceptOne(Message.buildMessage(Constants.CHAT_MESSAGE_COMMAND, Constants.SERVER_NAME, nickname + " has joined the chat."), nickname);
        server.serverLog("Client set nickname to: " + nickname);
    }

    public void parseMessage(String message) {
        String[] decodedMessage = Message.decodeMessage(message);
        if (decodedMessage[0].equals(Constants.LEAVE_COMMAND)) {
            close();
            server.serverLog("Client " + nickname + " disconnected");
            server.toAll(Message.buildMessage(Constants.CHAT_MESSAGE_COMMAND, Constants.SERVER_NAME, nickname + " has left the chat."));
        } else {
            server.toAllExceptOne(Message.buildMessage(Constants.CHAT_MESSAGE_COMMAND, decodedMessage[1], decodedMessage[2]), nickname);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public PrintWriter getOutputStream() {
        return output;
    }

    public void close() {
        try {
            server.removeTCPClient(this);
            server.removeUDPClient(nickname);
            running.set(false);
            input.close();
            output.close();
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ignore) {}
    }
}