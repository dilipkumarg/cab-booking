package com.dilipkumarg.ud.cabbooking.helpers;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class InMemoryAutoIncrementTripIdentifierGenerator implements TripIdentifierGenerator {

    private final AtomicInteger generator = new AtomicInteger(0);

    @Override
    public Integer generate() {
        return generator.incrementAndGet();
    }
}
