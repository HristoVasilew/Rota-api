package auto.rota.api.validation;

import auto.rota.api.validation.anotation.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_PATTERN = "^[\\w\\-.]+@(?:[\\w\\-]+\\.)+[\\w\\-]{2,}$";

    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return pattern.matcher(email).matches();
    }
}