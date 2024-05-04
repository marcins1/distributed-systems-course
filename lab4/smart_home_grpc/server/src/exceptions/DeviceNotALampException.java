package exceptions;

public class DeviceNotALampException extends Exception {
    public DeviceNotALampException(String errorMessage) {
        super(errorMessage);
    }
}
