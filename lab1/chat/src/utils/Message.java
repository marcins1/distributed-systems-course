package utils;

public class Message {
    private static final String[] messageTypes = {
            Constants.SETTING_NICKNAME_COMMAND,
            Constants.SET_NICKNAME_COMMAND,
            Constants.CHAT_MESSAGE_COMMAND,
            Constants.UDP_CONNECT_COMMAND,
            Constants.UDP_MESSAGE_COMMAND,
            Constants.MULTICAST_MESSAGE_COMMAND,
            Constants.LEAVE_COMMAND,
            Constants.INCORRECT_MESSAGE_COMMAND,
    };

    private static final String[] clientSpecificChatCommands = {
            Constants.UDP_MESSAGE_COMMAND,
            Constants.MULTICAST_MESSAGE_COMMAND,
            Constants.LEAVE_COMMAND,
    };

    public static String buildMessage(String type, String username, String message) {
        return type + Constants.MESSAGE_SEPARATOR + username + Constants.MESSAGE_SEPARATOR + message;
    }

    public static boolean isCommandCorrect(String command) {
        for (String messageType : messageTypes) {
            if (command.equals(messageType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecificClientChatCommand(String command) {
        for (String clientChatCommand : clientSpecificChatCommands) {
            if (command.equals(clientChatCommand)) {
                return true;
            }
        }
        return false;
    }

    public static String[] decodeMessage(String message) {
        String[] messageParts = message.split(Constants.MESSAGE_SEPARATOR);
        if (messageParts.length != 3 || !isCommandCorrect(messageParts[0])) {
            return new String[]{Constants.INCORRECT_MESSAGE_COMMAND, Constants.DEFAULT_USERNAME, message};
        }
        return messageParts;
    }
}
