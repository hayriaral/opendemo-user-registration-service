package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.validator;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.PhoneNumberConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * Phone number constraint validator.
 *
 * @author Hayri Aral
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, CharSequence> {

    /**
     * E.164 is a standard for formatting phone numbers that includes a country code prefixed by a plus sign
     * (e.g., +1 for the United States), followed by the local phone number.
     * The country code can be 1-3 digits in length, and the local phone number can be up to a maximum of 14 digits
     * in length.
     */
    private static final Pattern PHONE_NUMBER_E164_REGEX = Pattern
            .compile("^\\+[1-9]\\d{1,14}$");

    @Override
    public boolean isValid(CharSequence phoneNumber, ConstraintValidatorContext context) {

        if (phoneNumber == null) {
            return true;
        }

        return PHONE_NUMBER_E164_REGEX.matcher(phoneNumber).matches();
    }
}
