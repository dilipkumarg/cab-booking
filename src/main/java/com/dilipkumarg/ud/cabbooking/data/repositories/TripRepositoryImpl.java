package com.dilipkumarg.ud.cabbooking.data.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.dilipkumarg.ud.cabbooking.data.entities.Trip;

@Repository
public class TripRepositoryImpl extends InMemoryCrudRepository<Trip, Integer> implements TripRepository {
    @Override
    public List<Trip> findByDriver(final String driverId) {
        return super.findAll().stream()
                .filter(trip -> trip.getDriver().getDriverId().equalsIgnoreCase(driverId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Trip> findByRider(final String riderId) {
        return super.findAll().stream()
                .filter(trip -> trip.getRider().getRiderId().equalsIgnoreCase(riderId))
                .collect(Collectors.toList());
    }
}
