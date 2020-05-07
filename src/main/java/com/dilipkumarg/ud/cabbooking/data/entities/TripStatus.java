package com.dilipkumarg.ud.cabbooking.data.entities;

public enum TripStatus {
    BOOKED {
        @Override
        public boolean canBeUpdated(final TripStatus newStatus) {
            return newStatus == TripStatus.STARTED;
        }
    },
    STARTED {
        @Override
        public boolean canBeUpdated(final TripStatus newStatus) {
            return newStatus == TripStatus.COMPLETED;
        }
    },
    COMPLETED {
        @Override
        public boolean canBeUpdated(final TripStatus newStatus) {
            return false;
        }
    };

    public abstract boolean canBeUpdated(TripStatus newStatus);
}
