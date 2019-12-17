package pl.swislowski.kamil.project.platerecognition.spring.api.exception;

import java.io.IOException;

public class RegistrationPlateNoContentException extends RegistrationPlateException {
    public RegistrationPlateNoContentException(String message) {
        super(message);
    }

    public RegistrationPlateNoContentException(String message, Exception cause) {
        super(message, cause);
    }
}
