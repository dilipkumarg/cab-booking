package com.dilipkumarg.ud.cabbooking.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dilipkumarg.ud.cabbooking.data.entities.Coordinate;
import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;
import com.dilipkumarg.ud.cabbooking.data.repositories.DriverRepository;
import com.dilipkumarg.ud.cabbooking.exceptions.CannotDriverUpdateStatusException;

@Service
public class DriverStatusServiceImpl implements DriverStatusService {

    private final DriverRepository repository;
    private final DriverService driverService;
    @Value("${app.drivers.matching.radius}")
    private int driverMatchingRadius;

    public DriverStatusServiceImpl(
            final DriverRepository repository, final DriverService driverService) {
        this.repository = repository;
        this.driverService = driverService;
    }

    @Override
    public Driver updateLocation(
            final String driverId, final Coordinate coordinate) {
        final Driver driver = driverService.getById(driverId);
        driver.setCoordinate(coordinate);
        driver.setLastUpdatedAt(Instant.now());
        return repository.update(driverId, driver);
    }

    @Override
    public Driver updateDriverStatus(final String driverId, final DriverStatus newStatus) {
        final Driver driver = driverService.getById(driverId);

        if (driver.getStatus().canUpdate(newStatus)) {
            driver.setLastUpdatedAt(Instant.now());
            driver.setStatus(newStatus);
            return repository.update(driverId, driver);
        } else {
            throw new CannotDriverUpdateStatusException("Status cannot be updated from:" + driver.getStatus() + ", " +
                    "to:" + newStatus);
        }
    }

    @Override
    public List<Driver> findDriverByLocation(final Coordinate source) {
        return repository.findNearDrivers(DriverStatus.AVAILABLE, source, driverMatchingRadius);
    }
}
