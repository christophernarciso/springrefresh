package com.cnar.kurime.util.exceptions;
public class MediaNotFoundException extends Exception {
    public MediaNotFoundException() {
        super();
    }

    public MediaNotFoundException(String message) {
        super(message);
    }

    public MediaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MediaNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MediaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
