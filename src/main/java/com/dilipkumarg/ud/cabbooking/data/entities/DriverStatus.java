package com.dilipkumarg.ud.cabbooking.data.entities;

public enum DriverStatus {
    AVAILABLE {
        @Override
        public boolean canUpdate(final DriverStatus newStatus) {
            return true; // all possible
        }
    },
    ON_TRIP {
        @Override
        public boolean canUpdate(final DriverStatus newStatus) {
            return newStatus == AVAILABLE;
        }
    },
    UN_AVAILABLE {
        @Override
        public boolean canUpdate(final DriverStatus newStatus) {
            return newStatus == AVAILABLE;
        }
    };

    public abstract boolean canUpdate(DriverStatus newStatus);
}
