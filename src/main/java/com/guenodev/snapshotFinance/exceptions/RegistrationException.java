package com.guenodev.snapshotFinance.exceptions;

import com.guenodev.snapshotFinance.enums.MessageRegistration;

public class RegistrationException extends Throwable {

    MessageRegistration messageRegistration;

    public RegistrationException() {
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(MessageRegistration messageRegistration) {
        this.messageRegistration = messageRegistration;
    }

    public MessageRegistration getMessageRegistration() {
        return messageRegistration;
    }
}
