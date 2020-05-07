package com.dilipkumarg.ud.cabbooking.exceptions;

public class DriverNotFoundException extends NotFoundException {
    public DriverNotFoundException(final String message) {
        super(message);
    }

    public DriverNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
