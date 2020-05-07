package com.dilipkumarg.ud.cabbooking.exceptions;

public class CannotUpdateTripStatusException extends AppException {
    public CannotUpdateTripStatusException(final String message) {
        super(message);
    }

    public CannotUpdateTripStatusException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
