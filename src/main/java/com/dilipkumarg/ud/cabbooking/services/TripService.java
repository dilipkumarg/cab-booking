package com.dilipkumarg.ud.cabbooking.services;

import java.util.List;

import com.dilipkumarg.ud.cabbooking.data.entities.Trip;
import com.dilipkumarg.ud.cabbooking.data.entities.TripRequest;

public interface TripService {

    Trip createTrip(TripRequest request);

    Trip startTrip(Integer tripId);

    Trip endTrip(Integer tripId);

    List<Trip> findRiderRecentTrips(String riderId); // can be paginated

    List<Trip> findDriverRecentTrips(String driverId);
}
