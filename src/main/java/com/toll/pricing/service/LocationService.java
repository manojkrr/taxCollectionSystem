package com.toll.pricing.service;

import com.toll.pricing.domain.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    /**
     * Retrieves all the Locations
     * */
    List<Location> getAllLocations();

    /**
     * Retrieves the Locations by the name
     * */
    Optional<Location> getLocationByName(String locationName);

    /**
     * Calculates total distance between
     * the entry location and exit location
     * */
    double calculateDistanceInKms(Location entryLocation, Location exitLocation);
}
