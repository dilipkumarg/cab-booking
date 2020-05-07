package com.dilipkumarg.ud.cabbooking.data.entities;

import lombok.Data;

@Data
public class Vehicle {
    private String rcNo;
    private String brand;
    private String model;

    private VehicleType vehicleType = VehicleType.PRIME;

//    private boolean active;
}
