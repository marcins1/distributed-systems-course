package client;

import utils.Constants;
import utils.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputHandler implements Runnable {
    private final Client client;
    private final PrintWriter outputStream;
    private final BufferedReader inputReader;

    public InputHandler(Client client, PrintWriter outputStream) {
        this.client = client;
        this.outputStream = outputStream;
        this.inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        try {
            while (client.getRunning().get()) {
                String message = inputReader.readLine();
                parseMessage(message);
            }
        } catch (Exception ignore) {}
    }

    private void parseMessage(String userInput) throws IOException {
        if (!client.getRunning().get()) return;
        String commandToExecute;
        if (client.isSettingNickname().get()) {
            if (userInput.equals(Constants.LEAVE_COMMAND)) {
                commandToExecute = Constants.LEAVE_COMMAND;
            } else {
                commandToExecute = Constants.SETTING_NICKNAME_COMMAND;
            }
        } else if (Message.isSpecificClientChatCommand(userInput)) {
            commandToExecute = userInput;
        } else {
            commandToExecute = Constants.CHAT_MESSAGE_COMMAND;
        }
        switch (commandToExecute) {
            case Constants.CHAT_MESSAGE_COMMAND -> {
                if (userInput.isEmpty()) {
                    System.out.println("Empty message entered");
                    return;
                }
                outputStream.println(Message.buildMessage(Constants.CHAT_MESSAGE_COMMAND, client.getNickname(), userInput));
            }
            case Constants.UDP_MESSAGE_COMMAND -> {
                String asciiArt = Message.buildMessage(Constants.UDP_MESSAGE_COMMAND, client.getNickname(), Constants.ASCII_ART);
                System.out.println("Ascii art sent");
                client.sendUDPMessage(asciiArt);
            }
            case Constants.MULTICAST_MESSAGE_COMMAND -> {
                String asciiArt = Message.buildMessage(Constants.MULTICAST_MESSAGE_COMMAND, client.getNickname(), Constants.ASCII_ART);
                client.sendMulticastMessage(asciiArt);
            }
            case Constants.SETTING_NICKNAME_COMMAND -> {
                String message = Message.buildMessage(Constants.SETTING_NICKNAME_COMMAND, userInput, userInput);
                outputStream.println(message);
            }
            case Constants.LEAVE_COMMAND -> {
                outputStream.println(Message.buildMessage(Constants.LEAVE_COMMAND, client.getNickname(), "."));
                System.out.println("Leaving chat...");
                inputReader.close();
                outputStream.close();
                client.stop();
            }
        }
    }
}