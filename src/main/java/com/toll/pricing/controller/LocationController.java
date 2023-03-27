package com.toll.pricing.controller;

import com.toll.pricing.domain.Location;
import com.toll.pricing.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    //API to retrieve all the locations
    @GetMapping
    @ResponseBody
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }
}
