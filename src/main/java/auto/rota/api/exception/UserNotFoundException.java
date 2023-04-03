package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RotaApiException {
    public UserNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }
}
