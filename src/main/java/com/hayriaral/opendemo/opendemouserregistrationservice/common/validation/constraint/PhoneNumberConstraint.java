package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks that the annotated {@code CharSequence} is a valid phone number.
 * <p>
 * {@code null} is considered valid.
 *
 * @author Hayri Aral
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
public @interface PhoneNumberConstraint {

    String message() default "{validation.constraint.ValidPhoneNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return the allowed phone number format Per default E.164 phone number allowed
     * @see PhoneNumberConstraint.Format
     */
    Format format() default Format.E164;

    /**
     * Required phone number format
     */
    enum Format {
        /**
         * The E.164 international standard for phone number
         */
        E164
    }
}
