package com.hayriaral.opendemo.opendemouserregistrationservice.validation.constraint.validator;

import com.hayriaral.opendemo.opendemouserregistrationservice.util.RegexPatterns;
import com.hayriaral.opendemo.opendemouserregistrationservice.validation.constraint.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Custom phone number validator.
 * Null value considered as valid.
 */
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {

        if (phoneNumber == null) {
            return true;
        }

        Pattern pattern = Pattern.compile(RegexPatterns.PHONE_NUMBER_E164);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
