package auto.rota.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RotaApiException extends Exception {
    private final HttpStatus httpStatus;

    public RotaApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public RotaApiException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

}
