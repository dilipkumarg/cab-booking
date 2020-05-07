package com.dilipkumarg.ud.cabbooking.services;

import java.util.List;

import com.dilipkumarg.ud.cabbooking.data.entities.Driver;

public interface DriverService {

    Driver register(Driver driver);

    Driver getById(String driverId);

    List<Driver> findAllDrivers();


}
