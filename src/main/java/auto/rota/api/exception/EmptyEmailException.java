package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class EmptyEmailException extends RotaApiException {
    public EmptyEmailException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public EmptyEmailException(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, message, cause);
    }
}

