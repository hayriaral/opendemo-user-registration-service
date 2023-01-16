package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.validator;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraints.PhoneNumberConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.hayriaral.opendemo.opendemouserregistrationservice.common.constants.Regex.PHONE_NUMBER_E164_REGEX;

/**
 * Phone number constraint validator.
 *
 * @author Hayri Aral
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, CharSequence> {

    //TODO: init format then validate according to selected format

    @Override
    public boolean isValid(CharSequence phoneNumber, ConstraintValidatorContext context) {

        if (phoneNumber == null) {
            return true;
        }

        return PHONE_NUMBER_E164_REGEX.matcher(phoneNumber).matches();
    }
}
