package account.validation.validator;

import account.validation.ValidEmail;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else if (!email.matches("\\w+(@acme.com)$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mail does not include @acme.com");
        }
        return true;
    }
}
