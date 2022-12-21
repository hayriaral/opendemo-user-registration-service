package com.hayriaral.opendemo.opendemouserregistrationservice.validation.constraint.validator;

import com.hayriaral.opendemo.opendemouserregistrationservice.util.RegexPatterns;
import com.hayriaral.opendemo.opendemouserregistrationservice.validation.constraint.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Custom email validator.
 * Null value considered as valid.
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if (email == null) {
            return true;
        }

        Pattern pattern = Pattern.compile(RegexPatterns.EMAIL);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
