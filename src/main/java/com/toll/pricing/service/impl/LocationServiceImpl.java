package com.toll.pricing.service.impl;

import com.toll.pricing.domain.Location;
import com.toll.pricing.domain.Route;
import com.toll.pricing.repository.LocationRepository;
import com.toll.pricing.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> getLocationByName(String locationName) {
        return locationRepository.findByName(locationName);
    }

    @Override
    public double calculateDistanceInKms(Location entryLocation, Location exitLocation) {
        //If entry location and exit location both are same
        if (entryLocation.getLocationId().equals(exitLocation.getLocationId())) {
            return 0;
        }
        Location currentLocation = locationRepository.findById(entryLocation.getLocationId());
        double totalDistance = 0;
        //Traversing from entry location to exit location
        while (currentLocation != null && !currentLocation.equals(exitLocation)) {
            for (Route route : currentLocation.getRoutes()) {
                //Check if the Route is to the next location
                if (isNextLocation(currentLocation, exitLocation, route.getToLocationId())) {
                    totalDistance += route.getDistance();
                    currentLocation = locationRepository.findById(route.getToLocationId());
                    break;
                }
            }
        }
        return totalDistance;
    }

    /**
     * method checks if the toLocationId
     * is between the currentLocation and exitLocation.
     * */
    private boolean isNextLocation(Location current, Location exitLocation, long toNextRouteLocationId) {
        return current.getLocationId() < toNextRouteLocationId && toNextRouteLocationId <= exitLocation.getLocationId() ||
                current.getLocationId() > toNextRouteLocationId && toNextRouteLocationId >= exitLocation.getLocationId();
    }
}
