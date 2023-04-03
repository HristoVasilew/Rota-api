package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class InvalidImageException extends RotaApiException {
    public InvalidImageException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public InvalidImageException(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, message, cause);
    }
}

