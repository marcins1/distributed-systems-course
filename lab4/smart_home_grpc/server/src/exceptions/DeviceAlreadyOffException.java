package exceptions;

public class DeviceAlreadyOffException extends Exception {
    public DeviceAlreadyOffException(String errorMessage) {
        super(errorMessage);
    }
}
