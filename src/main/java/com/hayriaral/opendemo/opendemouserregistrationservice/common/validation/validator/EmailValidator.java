package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.validator;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraints.EmailConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.hayriaral.opendemo.opendemouserregistrationservice.common.util.constants.Regex.EMAIL_REGEX;

/**
 * Email constraint validator.
 *
 * @author Hayri Aral
 */
public class EmailValidator implements ConstraintValidator<EmailConstraint, CharSequence> {

    @Override
    public boolean isValid(CharSequence email, ConstraintValidatorContext context) {

        if (email == null) {
            return true;
        }

        return EMAIL_REGEX.matcher(email).matches();
    }
}
