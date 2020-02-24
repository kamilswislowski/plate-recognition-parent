package pl.swislowski.kamil.project.platerecognition.spring.api.exception;

public class PlateRecognizerException extends Exception {
    public PlateRecognizerException(String message) {
        super(message);
    }

    public PlateRecognizerException(String message, Throwable cause) {
        super(message, cause);
    }
}
