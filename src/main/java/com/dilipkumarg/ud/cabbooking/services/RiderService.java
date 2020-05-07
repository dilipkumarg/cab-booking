package com.dilipkumarg.ud.cabbooking.services;

import java.util.List;

import com.dilipkumarg.ud.cabbooking.data.entities.Rider;

public interface RiderService {

    Rider create(Rider rider);

    Rider getById(String name);

    List<Rider> findAll();
}
