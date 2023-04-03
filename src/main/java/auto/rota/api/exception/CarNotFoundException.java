package auto.rota.api.exception;

import org.springframework.http.HttpStatus;

public class CarNotFoundException extends RotaApiException {
    public CarNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }
}
