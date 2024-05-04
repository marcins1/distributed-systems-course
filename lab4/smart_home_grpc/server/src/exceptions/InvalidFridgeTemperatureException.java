package exceptions;

public class InvalidFridgeTemperatureException extends Exception {
    public InvalidFridgeTemperatureException(String errorMessage) {
        super(errorMessage);
    }
}
