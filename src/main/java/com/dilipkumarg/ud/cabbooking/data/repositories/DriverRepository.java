package com.dilipkumarg.ud.cabbooking.data.repositories;

import java.util.List;

import com.dilipkumarg.ud.cabbooking.data.entities.Coordinate;
import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;

public interface DriverRepository extends CrudRepository<Driver, String> {

    List<Driver> findNearDrivers(DriverStatus status, Coordinate coordinate, int radius);
}
