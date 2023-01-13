package com.hayriaral.opendemo.opendemouserregistrationservice.user.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Optional;
import java.util.UUID;

@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class User {

    /**
     * The unique ID of the user.
     */
    private final UserId id;
    private final EmailAddress emailAddress;
    private final PhoneNumber phoneNumber;

    public Optional<UserId> getId() {

        return Optional.ofNullable(this.id);
    }

    public Optional<EmailAddress> getEmailAddress() {

        return Optional.ofNullable(this.emailAddress);
    }

    public Optional<PhoneNumber> getPhoneNumber() {

        return Optional.ofNullable(this.phoneNumber);
    }

    @Value
    public static class UserId {

        @NonNull
        private UUID value;
    }

}
