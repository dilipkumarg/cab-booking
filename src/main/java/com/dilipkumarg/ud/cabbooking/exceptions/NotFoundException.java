package com.dilipkumarg.ud.cabbooking.exceptions;

public class NotFoundException extends AppException {
    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
