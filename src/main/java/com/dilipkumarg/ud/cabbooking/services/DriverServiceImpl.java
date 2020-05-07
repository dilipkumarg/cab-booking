package com.dilipkumarg.ud.cabbooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;
import com.dilipkumarg.ud.cabbooking.data.repositories.DriverRepository;
import com.dilipkumarg.ud.cabbooking.exceptions.DriverNotFoundException;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    public DriverServiceImpl(final DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver register(final Driver driver) {
        driver.setDriverId(driver.getUser().getUserId());
        driver.setStatus(DriverStatus.AVAILABLE);
        return repository.save(driver.getDriverId(), driver);
    }

    @Override
    public Driver getById(final String driverId) {
        return repository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(driverId));
    }

    @Override
    public List<Driver> findAllDrivers() {
        return new ArrayList<>(repository.findAll());
    }
}
