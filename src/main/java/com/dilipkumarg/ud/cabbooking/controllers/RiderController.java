package com.dilipkumarg.ud.cabbooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilipkumarg.ud.cabbooking.config.Constants;
import com.dilipkumarg.ud.cabbooking.data.entities.Rider;
import com.dilipkumarg.ud.cabbooking.data.entities.Trip;
import com.dilipkumarg.ud.cabbooking.services.RiderService;
import com.dilipkumarg.ud.cabbooking.services.TripService;

@RestController
@RequestMapping(Constants.API_BASE_PATH + "/riders")
public class RiderController {

    private final RiderService riderService;
    private final TripService tripService; // should be called from service layer, simplicity am doing this

    @Autowired
    public RiderController(
            final RiderService riderService, final TripService tripService) {
        this.riderService = riderService;
        this.tripService = tripService;
    }

    @PostMapping
    public Rider register(@RequestBody Rider rider) {
        return riderService.create(rider);
    }

    @GetMapping
    public List<Rider> findAll() {
        return riderService.findAll();
    }

    @GetMapping("/{riderId}")
    public Rider findById(@PathVariable String riderId) {
        return riderService.getById(riderId);
    }

    @GetMapping("/{riderId}/trips")
    public List<Trip> findAllRiderTrips(@PathVariable String riderId) {
        return tripService.findRiderRecentTrips(riderId);
    }
}
