package exceptions;

public class DeviceNotFoundException extends Exception {
    public DeviceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
