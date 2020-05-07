package com.dilipkumarg.ud.cabbooking.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilipkumarg.ud.cabbooking.config.Constants;
import com.dilipkumarg.ud.cabbooking.data.entities.Trip;
import com.dilipkumarg.ud.cabbooking.data.entities.TripRequest;
import com.dilipkumarg.ud.cabbooking.services.TripService;

@RestController
@RequestMapping(Constants.API_BASE_PATH + "/trips")
public class TripController {

    private final TripService tripService;

    public TripController(final TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public Trip createTrip(@RequestBody TripRequest request) {
        return tripService.createTrip(request);
    }

    @PostMapping("/{tripId}/start")
    public Trip startTrip(@PathVariable Integer tripId) {
        return tripService.startTrip(tripId);
    }

    @PostMapping("/{tripId}/complete")
    public Trip completeTrip(@PathVariable Integer tripId) {
        return tripService.endTrip(tripId);
    }
}
