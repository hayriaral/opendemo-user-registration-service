package com.hayriaral.opendemo.opendemouserregistrationservice.user.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailAddressTest {

    @Test
    void emailAddressCreation() {
        EmailAddress email = new EmailAddress("test@example.com");
        assertEquals("test@example.com", email.getValue());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void emailAddressCreation_whenNullValue_shouldThrowNullPointerException() {
        Executable createEmailAddress = () -> new EmailAddress(null);
        assertThrows(NullPointerException.class, createEmailAddress);
    }
}
