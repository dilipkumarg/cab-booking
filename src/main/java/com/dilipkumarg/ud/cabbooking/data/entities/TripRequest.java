package com.dilipkumarg.ud.cabbooking.data.entities;

import lombok.Data;

@Data
public class TripRequest {
    private Coordinate source;
    private Coordinate destination;

    private String riderId;
    private VehicleType vehicleType;
}
