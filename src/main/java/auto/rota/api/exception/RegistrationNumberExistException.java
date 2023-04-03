package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class RegistrationNumberExistException extends RotaApiException {
    public RegistrationNumberExistException(String message) {
        super(HttpStatus.CONFLICT, message);
    }

    public RegistrationNumberExistException(String message, Throwable cause) {
        super(HttpStatus.CONFLICT, message, cause);
    }
}

