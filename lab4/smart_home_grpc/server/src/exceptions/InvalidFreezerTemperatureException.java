package exceptions;

public class InvalidFreezerTemperatureException extends Exception {
    public InvalidFreezerTemperatureException(String errorMessage) {
        super(errorMessage);
    }
}
