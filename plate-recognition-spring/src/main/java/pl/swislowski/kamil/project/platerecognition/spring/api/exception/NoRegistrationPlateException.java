package pl.swislowski.kamil.project.platerecognition.spring.api.exception;

public class NoRegistrationPlateException extends RegistrationPlateException {
    public NoRegistrationPlateException(String message) {
        super(message);
    }

    public NoRegistrationPlateException(String message, Throwable cause) {
        super(message, cause);
    }
}
