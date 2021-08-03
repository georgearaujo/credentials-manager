package com.edu.credentialsmanager.domain.valueobjects;

import com.edu.credentialsmanager.domain.exception.InvalidEmailException;

import java.util.regex.Pattern;

public class Email {
    private static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE);

    private String value;

    public Email(String value) {
        this.value = value != null ? value : "";
        var matcher = VALID_EMAIL_REGEX.matcher(this.value);
        if(!matcher.find()) {
            throw new InvalidEmailException();
        }
    }
}
