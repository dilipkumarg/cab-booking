package com.dilipkumarg.ud.cabbooking.data.entities;

import java.time.Instant;

import lombok.Data;

@Data
public class Driver {
    private String driverId;
    private User user;

    private DriverStatus status;

    private Coordinate coordinate;
    private Instant lastUpdatedAt;

    private Vehicle vehicle;
}
