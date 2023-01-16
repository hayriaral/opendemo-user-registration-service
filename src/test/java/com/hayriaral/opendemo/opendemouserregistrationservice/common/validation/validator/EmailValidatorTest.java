package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
class EmailValidatorTest {
    private EmailValidator validator;
    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new EmailValidator();
    }

    /**
     * This test case covers the scenario where the email is null and should be considered valid.
     */
    @Test
    void isValid_whenEmailIsNull_shouldReturnTrue() {
        assertTrue(validator.isValid(null, context));
    }

    /**
     * This test case covers the scenario where the email is empty and should be invalid.
     */
    @Test
    void isValid_whenEmailIsEmpty_shouldReturnFalse() {
        assertFalse(validator.isValid("", context));
    }

    /**
     * Test the scenario where the email is valid.
     *
     * @param email valid email
     */
    @ParameterizedTest
    @MethodSource("validEmails")
    void isValid_whenEmailsAreValid_shouldReturnTrue(String email) {
        assertTrue(validator.isValid(email, context));
    }

    @ParameterizedTest
    @MethodSource("invalidEmails")
    void isValid_whenEmailsAreInvalid_shouldReturnFalse(String email) {
        assertFalse(validator.isValid(email, context));
    }

    private static Stream<Arguments> validEmails() {
        return Stream.of(
                arguments("test@example.com"), // valid local part and a domain part
                arguments("test+123@example.com"), // valid local part of the email address contains a special character (+) that is allowed
                arguments("test.123@example.com"), // valid local part of the email address contains a period (.) which is allowed
                arguments("test@123.com"), // valid domain part of the email address contains a numeric subdomain (123) which is allowed.
                arguments("test@subdomain.domain.com"), // valid domain part of the email address contains multiple subdomains (subdomain and domain) which is allowed.
                arguments("some_name@example.co.uk"), // valid domain part of the email address contains a country-code top-level domain (ccTLD) (co.uk) which is allowed.
                arguments("john.doe@example.com"),
                arguments("my.name+tag@example.com"),
                arguments("test123@example.com")
        );
    }

    private static Stream<Arguments> invalidEmails() {
        return Stream.of(
                arguments("test@domain@domain.com"), // invalid local part of the email address contains an @ symbol, which is not allowed by the regex. The local part can only contain one @ symbol.
                arguments("test#domain.com"), // invalid the local part of the email address contains a special character (#) that is not allowed by the regex. The regex only allows for certain special characters such as ., +, and -.
                arguments("test@domain.valid"), // invalid domain part of the email address contains an invalid TLD (top-level domain) (invalid). Only allows for valid TLDs such as com, org, net, and others
                arguments("testexample.com"),
                arguments("test@.com"),
                arguments("test@example."),
                arguments("@example.com"),
                arguments("test@"),
                arguments("example@com"),
                arguments("example@com?"),
                arguments("example@com..tr")
        );
    }
}
