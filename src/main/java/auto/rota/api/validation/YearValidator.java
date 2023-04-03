package auto.rota.api.validation;

import auto.rota.api.validation.anotation.ValidYear;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Year;

public class YearValidator implements ConstraintValidator<ValidYear, Integer> {

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {

        if (year != 0) {
            return year >= 1886 && year <= Year.now().getValue();
        }

        return false;
    }
}
