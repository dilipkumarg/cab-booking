package com.dilipkumarg.ud.cabbooking.data.entities;

import java.time.Instant;

import lombok.Data;

@Data
public class Trip {
    private Integer tripId;

    private Coordinate source;
    private Coordinate destination;

    private Driver driver;
    private Vehicle vehicle;

    private Rider rider;

    private TripStatus tripStatus;
    private double cost;

    private Instant bookedAt;
    private Instant startedAt;
    private Instant completedAt;

}
