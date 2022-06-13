package com.cnar.kurime.util.exceptions;

public class MediaTypeNotFoundException  extends Exception {
    public MediaTypeNotFoundException() {
        super();
    }

    public MediaTypeNotFoundException(String message) {
        super(message);
    }

    public MediaTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MediaTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MediaTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
