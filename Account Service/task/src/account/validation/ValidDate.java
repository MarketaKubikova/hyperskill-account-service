package account.validation;

import account.validation.validator.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = DateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
    String message() default "Date must be in MMMM-YYYY format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
