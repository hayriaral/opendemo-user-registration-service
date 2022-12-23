package com.hayriaral.opendemo.opendemouserregistrationservice.common.validation.constraint.validator;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
class PhoneNumberValidatorTest {
    private PhoneNumberValidator validator;
    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new PhoneNumberValidator();
    }

    /**
     * This test case covers the scenario where the phone number is null and should be considered valid.
     */
    @Test
    void isValid_whenPhoneNumberIsNull_shouldReturnTrue() {
        assertTrue(validator.isValid(null, context));
    }

    /**
     * This test case covers the scenario where the phone number is empty and should be invalid.
     */
    @Test
    void isValid_whenPhoneNumberIsEmpty_shouldReturnFalse() {
        assertFalse(validator.isValid("", context));
    }

    /**
     * Test the scenario where the phone number is valid.
     *
     * @param phoneNumber valid phone number
     */
    @ParameterizedTest
    @MethodSource("validPhoneNumbers")
    void isValid_whenPhoneNumbersAreValid_shouldReturnTrue(String phoneNumber) {
        assertTrue(validator.isValid(phoneNumber, context));
    }

    /**
     * Test the scenario where the phone number is invalid.
     *
     * @param phoneNumber invalid phone number
     */
    @ParameterizedTest
    @MethodSource("invalidPhoneNumbers")
    void isValid_whenPhoneNumbersAreInvalid_shouldReturnFalse(String phoneNumber) {
        assertFalse(validator.isValid(phoneNumber, context));
    }

    private static Stream<Arguments> validPhoneNumbers() {
        return Stream.of(
                arguments("+905554442288"),
                arguments("+15555555555"),
                arguments("+442079460123"),
                arguments("+16502530000")
        );
    }

    private static Stream<Arguments> invalidPhoneNumbers() {
        return Stream.of(
                arguments("15555555555"), // missing the leading plus sign
                arguments("+01555555555"), // leading 0 in the country code
                arguments("+44 020 7946 0123"), // spaces and leading 0 in the national number
                arguments("+1234567890abc"), // contains letters
                arguments("+1234567890.") // contains punctuation
        );
    }
}
