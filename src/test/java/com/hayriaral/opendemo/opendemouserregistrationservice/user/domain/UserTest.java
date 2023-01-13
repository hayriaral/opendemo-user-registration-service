package com.hayriaral.opendemo.opendemouserregistrationservice.user.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void getId() {
        UUID uuid = UUID.randomUUID();
        User.UserId userId = new User.UserId(uuid);
        User user = new User(userId, null, null);

        Optional<User.UserId> result = user.getId();

        assertTrue(result.isPresent());
        assertEquals(uuid, result.get().getValue());
    }

    @Test
    void getId_whenNullId() {
        EmailAddress email = new EmailAddress("test@example.com");
        PhoneNumber phoneNumber = new PhoneNumber("+905998887766");
        User user = new User(null, email, phoneNumber);

        Optional<User.UserId> result = user.getId();

        assertFalse(result.isPresent());
        assertThrows(NoSuchElementException.class, result::get);
    }

    @Test
    void getEmailAddress() {
        EmailAddress emailAddress = new EmailAddress("test@example.com");
        User user = new User(null, emailAddress, null);

        Optional<EmailAddress> result = user.getEmailAddress();

        assertTrue(result.isPresent());
        assertEquals("test@example.com", result.get().getValue());
    }

    @Test
    void getEmailAddress_whenNullEmailAddress() {
        User user = new User(null, null, null);

        Optional<EmailAddress> result = user.getEmailAddress();

        assertFalse(result.isPresent());
        assertThrows(NoSuchElementException.class, result::get);
    }

    @Test
    void getPhoneNumber() {
        PhoneNumber phoneNumber = new PhoneNumber("+905998887766");
        User user = new User(null, null, phoneNumber);

        Optional<PhoneNumber> result = user.getPhoneNumber();

        assertTrue(result.isPresent());
        assertEquals("+905998887766", result.get().getValue());
    }

    @Test
    void getPhoneNumber_whenNullPhoneNumber() {
        User user = new User(null, null, null);

        Optional<PhoneNumber> result = user.getPhoneNumber();

        assertFalse(result.isPresent());
        assertThrows(NoSuchElementException.class, result::get);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void userCreation_whenNullUserIdValue_shouldThrowNullPointerException() {
        Executable createUserId = () -> new User.UserId(null);
        assertThrows(NullPointerException.class, createUserId);
    }
}
