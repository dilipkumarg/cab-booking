package com.dilipkumarg.ud.cabbooking.exceptions;

public class TripNotFoundException extends NotFoundException {
    public TripNotFoundException(final String message) {
        super(message);
    }

    public TripNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
