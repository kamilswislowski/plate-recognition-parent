package pl.swislowski.kamil.project.platerecognition.spring.api.exception;

public class RegistrationPlateException extends Exception {
    public RegistrationPlateException(String message) {
        super(message);
    }

    public RegistrationPlateException(String message, Throwable cause) {
        super(message, cause);
    }
}
