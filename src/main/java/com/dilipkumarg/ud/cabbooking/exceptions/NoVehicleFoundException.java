package com.dilipkumarg.ud.cabbooking.exceptions;

public class NoVehicleFoundException extends AppException {
    public NoVehicleFoundException(final String message) {
        super(message);
    }

    public NoVehicleFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
