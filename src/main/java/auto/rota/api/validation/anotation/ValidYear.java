package auto.rota.api.validation.anotation;

import auto.rota.api.validation.YearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = YearValidator.class)
@Documented
public @interface ValidYear {

    String message() default "Invalid year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}