package com.dilipkumarg.ud.cabbooking.services;

import java.util.List;

import com.dilipkumarg.ud.cabbooking.data.entities.Coordinate;
import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;

public interface DriverStatusService {

    Driver updateLocation(String driverId, Coordinate coordinate);

    Driver updateDriverStatus(String driverId, DriverStatus status);

    List<Driver> findDriverByLocation(Coordinate source);
}
