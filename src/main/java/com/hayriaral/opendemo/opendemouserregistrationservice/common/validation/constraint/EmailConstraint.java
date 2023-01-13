package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint;

import com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.validator.EmailValidator;
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
 * Checks that the annotated {@code CharSequence} is a valid email.
 * <p>
 * {@code null} is considered valid.
 *
 * @author Hayri Aral
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface EmailConstraint {

    String message() default "{validation.constraint.ValidEmail.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
