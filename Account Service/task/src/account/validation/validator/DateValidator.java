package account.validation.validator;

import account.validation.ValidDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, String> {
    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        if (string == null)
            return true;
        return (string
                .strip()
                .replace("\"", "")
                .strip().matches("^(1[0-2]|0?\\d)-20\\d{2}$"));
    }
}
