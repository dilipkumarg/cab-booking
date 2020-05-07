package com.dilipkumarg.ud.cabbooking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilipkumarg.ud.cabbooking.config.Constants;
import com.dilipkumarg.ud.cabbooking.data.entities.Coordinate;
import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;
import com.dilipkumarg.ud.cabbooking.data.entities.Trip;
import com.dilipkumarg.ud.cabbooking.services.DriverService;
import com.dilipkumarg.ud.cabbooking.services.DriverStatusService;
import com.dilipkumarg.ud.cabbooking.services.TripService;

@RestController
@RequestMapping(Constants.API_BASE_PATH + "/drivers")
public class DriverController {

    private final DriverService driverService;
    private final DriverStatusService statusService;
    private final TripService tripService;

    public DriverController(
            final DriverService driverService,
            final DriverStatusService statusService,
            final TripService tripService) {
        this.driverService = driverService;
        this.statusService = statusService;
        this.tripService = tripService;
    }

    @PostMapping
    public Driver register(@RequestBody Driver driver) {
        return driverService.register(driver);
    }

    @GetMapping
    public List<Driver> findAllDriver() {
        return driverService.findAllDrivers();
    }

    @GetMapping("/{driverId}")
    public Driver findById(@PathVariable String driverId) {
        return driverService.getById(driverId);
    }

    @GetMapping("/{driverId}/trips")
    public List<Trip> findAllTripsForDriver(@PathVariable String driverId) {
        return tripService.findDriverRecentTrips(driverId);
    }

    @PostMapping("/{driverId}/location")
    public Driver updateLocation(@PathVariable String driverId, @RequestBody Coordinate coordinate) {
        return statusService.updateLocation(driverId, coordinate);
    }

    @PostMapping("/{driverId}/status")
    public Driver updateStatus(@PathVariable String driverId, @RequestParam("status") DriverStatus status) {
        return statusService.updateDriverStatus(driverId, status);
    }

}
