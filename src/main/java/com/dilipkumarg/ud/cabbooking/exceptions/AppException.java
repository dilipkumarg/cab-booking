package com.dilipkumarg.ud.cabbooking.exceptions;

public class AppException extends RuntimeException {
    public AppException(final String message) {
        super(message);
    }

    public AppException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
