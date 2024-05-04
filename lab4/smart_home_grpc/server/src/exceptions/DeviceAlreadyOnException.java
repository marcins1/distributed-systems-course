package exceptions;

public class DeviceAlreadyOnException extends Exception {
    public DeviceAlreadyOnException(String errorMessage) {
        super(errorMessage);
    }
}
