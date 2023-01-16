package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.validator.EmailValidator;
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
 * Checks that the annotated {@code CharSequence} is a valid email.
 * <p>
 * {@code null} is considered valid.
 *
 * @author Hayri Aral
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
@Repeatable(EmailConstraint.List.class)
public @interface EmailConstraint {

    String message() default "{validation.constraint.ValidEmail.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @EmailConstraint} constraints on the same element.
     *
     * @see EmailConstraint
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        EmailConstraint[] value();
    }
}
