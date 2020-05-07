package com.dilipkumarg.ud.cabbooking.data.repositories;

import java.util.List;

import com.dilipkumarg.ud.cabbooking.data.entities.Trip;

public interface TripRepository extends CrudRepository<Trip, Integer> {

    List<Trip> findByDriver(String driverId);

    List<Trip> findByRider(String riderId);
}
