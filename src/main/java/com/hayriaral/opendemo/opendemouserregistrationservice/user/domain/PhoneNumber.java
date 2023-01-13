package com.hayriaral.opendemo.opendemouserregistrationservice.user.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class PhoneNumber {

    @NonNull
    private final String value;
}
