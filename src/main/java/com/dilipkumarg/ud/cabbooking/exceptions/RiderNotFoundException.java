package com.dilipkumarg.ud.cabbooking.exceptions;

public class RiderNotFoundException extends NotFoundException {
    public RiderNotFoundException(final String message) {
        super(message);
    }

    public RiderNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
