package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.validator.PhoneNumberValidator;
import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.enums.PhoneNumberFormat;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks that the annotated {@code CharSequence} is a valid phone number.
 * <p>
 * {@code null} is considered valid.
 *
 * @author Hayri Aral
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
@Repeatable(PhoneNumberConstraint.List.class)
public @interface PhoneNumberConstraint {

    String message() default "{validation.constraint.ValidPhoneNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return the allowed phone number format Per default E.164 phone number allowed
     * @see PhoneNumberFormat
     */
    PhoneNumberFormat format() default PhoneNumberFormat.E164;

    /**
     * Defines several {@code @PhoneNumberConstraint} constraints on the same element.
     *
     * @see PhoneNumberConstraint
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        PhoneNumberConstraint[] value();
    }
}
