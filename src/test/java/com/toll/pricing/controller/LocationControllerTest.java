package com.toll.pricing.controller;

import com.toll.pricing.domain.Location;
import com.toll.pricing.service.LocationService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.toll.pricing.maker.LocationMaker.aLocation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationControllerTest {

    private final LocationService locationService = mock(LocationService.class);
    private final LocationController locationController = new LocationController(locationService);

    @Test
    public void testGetAllLocations() {
        // Setup
        List<Location> expectedLocations = Arrays.asList(
                aLocation(1L, "Location1"),
                aLocation(2L, "Location2")
        );
        when(locationService.getAllLocations()).thenReturn(expectedLocations);

        // Exercise
        List<Location> actualLocations = locationController.getAllLocations();

        // Verify
        assertThat(actualLocations).isEqualTo(expectedLocations);
    }
}
