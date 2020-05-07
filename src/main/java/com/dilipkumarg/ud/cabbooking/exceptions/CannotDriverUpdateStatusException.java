package com.dilipkumarg.ud.cabbooking.exceptions;

public class CannotDriverUpdateStatusException extends AppException {
    public CannotDriverUpdateStatusException(final String message) {
        super(message);
    }

    public CannotDriverUpdateStatusException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
