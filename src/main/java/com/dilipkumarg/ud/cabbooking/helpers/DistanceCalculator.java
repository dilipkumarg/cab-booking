package com.dilipkumarg.ud.cabbooking.helpers;

import org.springframework.stereotype.Component;

import com.dilipkumarg.ud.cabbooking.data.entities.Coordinate;

@Component
public class DistanceCalculator {

    public double findDistance(Coordinate from, Coordinate to) {
        final double xPow = Math.pow(from.getX() - to.getX(), 2);
        final double yPow = Math.pow(from.getY() - to.getY(), 2);

        return Math.sqrt(xPow + yPow);
    }
}
