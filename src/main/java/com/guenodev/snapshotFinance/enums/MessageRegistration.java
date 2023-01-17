package com.guenodev.snapshotFinance.enums;

public enum MessageRegistration {
    EMAIL_EXISTS("This e-mail already exists! Please try another one or contact us"),
    SUCCESSFUL_REGISTRATION("Successful registration!");

    private final String message;

    MessageRegistration(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
