package com.dilipkumarg.ud.cabbooking.data.repositories;

import org.springframework.stereotype.Repository;

import com.dilipkumarg.ud.cabbooking.data.entities.Rider;

@Repository
public class RiderRepositoryImpl extends InMemoryCrudRepository<Rider, String> implements RiderRepository {
}
