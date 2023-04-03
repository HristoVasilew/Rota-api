package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class EmailExistException extends RotaApiException {
    public EmailExistException(String message) {
        super(HttpStatus.CONFLICT, message);
    }

    public EmailExistException(String message, Throwable cause) {
        super(HttpStatus.CONFLICT, message, cause);
    }
}

