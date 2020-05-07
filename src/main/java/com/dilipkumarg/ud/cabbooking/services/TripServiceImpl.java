package com.dilipkumarg.ud.cabbooking.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dilipkumarg.ud.cabbooking.data.entities.Driver;
import com.dilipkumarg.ud.cabbooking.data.entities.DriverStatus;
import com.dilipkumarg.ud.cabbooking.data.entities.Trip;
import com.dilipkumarg.ud.cabbooking.data.entities.TripRequest;
import com.dilipkumarg.ud.cabbooking.data.entities.TripStatus;
import com.dilipkumarg.ud.cabbooking.data.repositories.TripRepository;
import com.dilipkumarg.ud.cabbooking.exceptions.CannotUpdateTripStatusException;
import com.dilipkumarg.ud.cabbooking.exceptions.NoVehicleFoundException;
import com.dilipkumarg.ud.cabbooking.exceptions.TripNotFoundException;
import com.dilipkumarg.ud.cabbooking.helpers.DistanceCalculator;
import com.dilipkumarg.ud.cabbooking.helpers.TripIdentifierGenerator;

@Service
public class TripServiceImpl implements TripService {

    private final DriverStatusService driverStatusService;
    private final TripRepository tripRepository;
    private final TripIdentifierGenerator identifierGenerator;
    private final DistanceCalculator distanceCalculator;
    private final RiderService riderService;

    @Value("${app.trip.cost.km}")
    private int costPerKm;

    public TripServiceImpl(
            final DriverStatusService driverStatusService,
            final TripRepository tripRepository,
            final TripIdentifierGenerator identifierGenerator,
            final DistanceCalculator distanceCalculator,
            final RiderService riderService) {
        this.driverStatusService = driverStatusService;
        this.tripRepository = tripRepository;
        this.identifierGenerator = identifierGenerator;
        this.distanceCalculator = distanceCalculator;
        this.riderService = riderService;
    }

    @Override
    public Trip createTrip(final TripRequest request) {
        final List<Driver> nearByDrivers = driverStatusService.findDriverByLocation(request.getSource());
        if (!nearByDrivers.isEmpty()) {
            final Driver driver = selectDriver(nearByDrivers);
            Trip trip = new Trip();
            trip.setTripId(identifierGenerator.generate());
            trip.setDriver(driver);
            trip.setVehicle(driver.getVehicle());
            trip.setRider(riderService.getById(request.getRiderId()));
            trip.setSource(request.getSource());
            trip.setDestination(request.getDestination());
            trip.setTripStatus(TripStatus.BOOKED);
            trip.setBookedAt(Instant.now());
            return tripRepository.save(trip.getTripId(), trip);
        } else {
            throw new NoVehicleFoundException("No vehicle found in near by:[" + request.getSource() + "]");
        }
    }

    @Override
    public Trip startTrip(final Integer tripId) {
        final Trip trip = getTrip(tripId);
        if (trip.getTripStatus() == TripStatus.BOOKED) {
            trip.setTripStatus(TripStatus.STARTED);
            trip.setStartedAt(Instant.now());
            return tripRepository.save(tripId, trip);
        } else {
            throw new CannotUpdateTripStatusException("Invalid trip status to start:" + trip.getTripStatus());
        }
    }

    @Override
    public Trip endTrip(final Integer tripId) {
        final Trip trip = getTrip(tripId);
        if (trip.getTripStatus() == TripStatus.STARTED) {
            final double distance = distanceCalculator.findDistance(trip.getSource(), trip.getDestination());
            trip.setTripStatus(TripStatus.COMPLETED);
            trip.setCompletedAt(Instant.now());
            trip.setCost(distance * costPerKm); // can be configured by vehicle type & extended to calculating start
            // and end time
            return tripRepository.save(tripId, trip);
        } else {
            throw new CannotUpdateTripStatusException("Invalid trip status to start:" + trip.getTripStatus());
        }
    }

    @Override
    public List<Trip> findRiderRecentTrips(final String riderId) {
        return tripRepository.findByRider(riderId);
    }

    @Override
    public List<Trip> findDriverRecentTrips(final String driverId) {
        return tripRepository.findByDriver(driverId);
    }

    private Trip getTrip(Integer tripId) {
        return tripRepository.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException(tripId + ""));
    }

    private Driver selectDriver(final List<Driver> nearByDrivers) {
        final Driver driver = nearByDrivers.get(0);
        driverStatusService.updateDriverStatus(driver.getDriverId(), DriverStatus.ON_TRIP);
        return driver;
    }
}
