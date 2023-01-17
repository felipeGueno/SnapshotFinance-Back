package com.guenodev.snapshotFinance.enums;

import org.springframework.http.HttpStatus;

public enum MessageRegistration {
    EMAIL_EXISTS("This e-mail already exists! Please try another one or contact us", HttpStatus.CONFLICT),

    EMPTY_EMAIL("Field e-mail is empty", HttpStatus.BAD_REQUEST),
    SUCCESSFUL_REGISTRATION("Successful registration!", HttpStatus.CREATED),

    EMPTY_DATA("Please type the user data registration", HttpStatus.BAD_REQUEST);

    private final String message;
    private HttpStatus httpStatus;

    MessageRegistration(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
