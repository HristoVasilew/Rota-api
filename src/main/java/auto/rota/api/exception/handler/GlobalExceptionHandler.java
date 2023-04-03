package auto.rota.api.exception.handler;

import auto.rota.api.exception.GlobalErrorResponse;
import auto.rota.api.exception.RotaApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RotaApiException.class)
    public ResponseEntity<GlobalErrorResponse> handleRotaApiException(RotaApiException exception) {
        GlobalErrorResponse errors = new GlobalErrorResponse();
        errors.setError(exception.getMessage());
        return new ResponseEntity<>(errors, exception.getHttpStatus());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        GlobalErrorResponse response = new GlobalErrorResponse();
        response.setError(String.valueOf(errors.values()));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
