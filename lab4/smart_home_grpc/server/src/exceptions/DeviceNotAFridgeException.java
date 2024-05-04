package exceptions;

public class DeviceNotAFridgeException extends Exception {
    public DeviceNotAFridgeException(String errorMessage) {
        super(errorMessage);
    }
}
