package com.dilipkumarg.ud.cabbooking.data.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.dilipkumarg.ud.cabbooking.data.entities.Coordinate;
import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;
import com.dilipkumarg.ud.cabbooking.helpers.DistanceCalculator;

@Repository
public class DriverRepositoryImpl extends InMemoryCrudRepository<Driver, String> implements DriverRepository {

    private final DistanceCalculator distanceCalculator;

    public DriverRepositoryImpl(final DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public List<Driver> findNearDrivers(
            final DriverStatus status, final Coordinate coordinate, final int radius) {
        return super.findAll().stream()
                .filter(driver -> driver.getStatus() == status)
                .filter(driver -> isInRadius(driver.getCoordinate(), coordinate, radius))
                .collect(Collectors.toList());
    }

    private boolean isInRadius(Coordinate coordinate, Coordinate toCheck, int radius) {
        return distanceCalculator.findDistance(coordinate, toCheck) < radius;
    }
}
