package com.hayriaral.opendemo.opendemouserregistrationservice.user.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class EmailAddress {

    @NonNull
    private final String value;
}
