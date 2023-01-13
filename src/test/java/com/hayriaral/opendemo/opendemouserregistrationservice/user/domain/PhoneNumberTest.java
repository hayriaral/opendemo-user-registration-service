package com.hayriaral.opendemo.opendemouserregistrationservice.user.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneNumberTest {

    @Test
    void phoneNumberCreation() {
        PhoneNumber phoneNumber = new PhoneNumber("123-456-7890");
        assertEquals("123-456-7890", phoneNumber.getValue());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void phoneNumberCreation_whenNullValue_shouldThrowNullPointerException() {
        Executable createPhoneNumber = () -> new PhoneNumber(null);
        assertThrows(NullPointerException.class, createPhoneNumber);
    }
}
