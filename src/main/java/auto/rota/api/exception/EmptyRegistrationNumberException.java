package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class EmptyRegistrationNumberException extends RotaApiException {
    public EmptyRegistrationNumberException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public EmptyRegistrationNumberException(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, message, cause);
    }
}

