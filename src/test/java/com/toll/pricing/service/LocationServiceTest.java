package com.toll.pricing.service;

import com.toll.pricing.domain.Location;
import com.toll.pricing.repository.LocationRepository;
import com.toll.pricing.service.impl.LocationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LocationServiceTest {

    private final LocationRepository locationRepository = new LocationRepository();
    private LocationService locationService;

    @Before
    public void setup() {

        locationService = new LocationServiceImpl(locationRepository);
    }

    @Test
    public void test_should_get_all_the_44_locations_from_repository() {
        //When
        List<Location> locations = locationService.getAllLocations();

        //Then
        assertEquals(44, locations.size());
    }

    @Test
    public void test_should_get_location_for_given_valid_name() {
        //Given
        String locationNameStub = "McCowan Road";

        //When
        Optional<Location> location = locationService.getLocationByName(locationNameStub);

        //Then
        assertTrue(location.isPresent());
    }


    @Test
    public void test_should_not_get_any_location_for_given_invalid_name() {
        //Given
        String locationNameStub = "McCowan Roads 5";

        //When
        Optional<Location> location = locationService.getLocationByName(locationNameStub);

        //Then
        assertFalse(location.isPresent());
    }

    @Test
    public void test_should_calculate_distance_between_QEW_to_Dundas_Street() {
        //Given
        Location locationQewStub = Location.builder().locationId(1L).build();
        Location locateDundasStreetStub = Location.builder().locationId(2L).build();

        //When
        double distance = locationService.calculateDistanceInKms(locationQewStub, locateDundasStreetStub);

        //Then
        assertEquals(6.062D, distance);
    }

    @Test
    public void test_should_calculate_distance_between_Dundas_Street_to_QEW() {
        //Given
        Location locationQewStub = Location.builder().locationId(1L).build();
        Location locateDundasStreetStub = Location.builder().locationId(2L).build();

        //When
        double distance = locationService.calculateDistanceInKms(locateDundasStreetStub, locationQewStub);

        //Then
        assertEquals(6.062D, distance);
    }

    @Test
    public void test_should_not_calculate_distance_between_same_location() {
        //Given
        Location locationQewStub = Location.builder().locationId(1L).build();

        //When
        double distance = locationService.calculateDistanceInKms(locationQewStub, locationQewStub);

        //Then
        assertEquals(0D, distance);
    }

    @Test
    public void test_should_not_calculate_distance_between_location_id_41_to_46() {
        //Given
        Location locationYorkDhuramLineStub = Location.builder().locationId(41L).build();
        Location locationSalemRoadStub = Location.builder().locationId(46L).build();

        //When
        double distance = locationService.calculateDistanceInKms(locationYorkDhuramLineStub, locationSalemRoadStub);

        //Then
        assertEquals(15.167D, distance);
    }


    @Test
    public void test_should_not_calculate_distance_between_location_id_46_to_41() {
        //Given
        Location locationYorkDhuramLineStub = Location.builder().locationId(41L).build();
        Location locationSalemRoadStub = Location.builder().locationId(46L).build();

        //When
        double distance = locationService.calculateDistanceInKms(locationSalemRoadStub, locationYorkDhuramLineStub);

        //Then
        assertEquals(7.854D, distance);
    }

}
