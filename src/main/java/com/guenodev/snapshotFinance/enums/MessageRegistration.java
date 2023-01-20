package com.guenodev.snapshotFinance.enums;

import org.springframework.http.HttpStatus;

public enum MessageRegistration {
    EMAIL_EXISTS("This e-mail already exists! Please try another one or contact us", HttpStatus.CONFLICT),

    EMPTY_EMAIL("Field e-mail is empty", HttpStatus.BAD_REQUEST),

    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),

    GROUP_NAME_MISSING("Group name is missing", HttpStatus.BAD_REQUEST),
    SUCCESSFUL_REGISTRATION("Successful registration!", HttpStatus.CREATED),

    EMPTY_DATA("Please type the data registration", HttpStatus.BAD_REQUEST),

    GROUP_EXIST_TO_ADM("There is already a group created by you with the same name", HttpStatus.CONFLICT);

    private String message;
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
