package com.dilipkumarg.ud.cabbooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dilipkumarg.ud.cabbooking.data.entities.Rider;
import com.dilipkumarg.ud.cabbooking.data.repositories.RiderRepository;
import com.dilipkumarg.ud.cabbooking.exceptions.RiderNotFoundException;

@Service
public class RiderServiceImpl implements RiderService {

    private final RiderRepository repository;

    public RiderServiceImpl(final RiderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rider create(final Rider rider) {
        rider.setRiderId(rider.getUser().getUserId());

        return repository.save(rider.getRiderId(), rider);
    }

    @Override
    public Rider getById(final String id) {
        return repository.findById(id).orElseThrow(() -> new RiderNotFoundException(id));
    }

    @Override
    public List<Rider> findAll() {
        return new ArrayList<>(repository.findAll());
    }
}
