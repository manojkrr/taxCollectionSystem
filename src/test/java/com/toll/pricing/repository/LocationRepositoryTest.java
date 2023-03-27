package com.toll.pricing.repository;

import com.toll.pricing.domain.Location;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LocationRepositoryTest {

    private final LocationRepository locationRepository = new LocationRepository();

    @Test
    public void test_should_load_all_the_locations_from_the_json_file() {
        //When
        List<Location> locations = locationRepository.findAll();

        //Then
        assertNotNull(locations);
        assertFalse(locations.isEmpty());
        assertEquals(44, locations.size());
    }

    @Test
    public void test_should_get_location_with_name_QEW() {
        //Given
        String locationNameStub = "QEW";

        //When
        Optional<Location> location = locationRepository.findByName(locationNameStub);

        //Then
        assertTrue(location.isPresent());
        assertEquals(1, location.get().getLocationId());
        assertEquals(locationNameStub, location.get().getName());
        assertEquals(2, location.get().getRoutes().get(0).getToLocationId());
        assertEquals(6.062D, location.get().getRoutes().get(0).getDistance());
    }

    @Test
    public void test_should_not_get_any_location_with_unknown_name() {
        //Given
        String locationNameStub = "NEW";

        //When
        Optional<Location> location = locationRepository.findByName(locationNameStub);

        //Then
        assertFalse(location.isPresent());
    }

    @Test
    public void test_should_get_location_of_Highway_27_for_location_id_20(){
        //Given
        long locationIdStub = 20;

        //When
        Location location = locationRepository.findById(locationIdStub);

        //Then
        assertNotNull(location);
        assertEquals(locationIdStub, location.getLocationId());
        assertEquals("Highway 27", location.getName());
        assertEquals(22, location.getRoutes().get(0).getToLocationId());
        assertEquals(4.061D, location.getRoutes().get(0).getDistance());
        assertEquals(19, location.getRoutes().get(1).getToLocationId());
        assertEquals(1.324D, location.getRoutes().get(1).getDistance());
    }

    @Test
    public void test_should_not_get_any_location_for_unknown_location_id_90(){
        //Given
        long locationIdStub = 90;

        //When
        Location location = locationRepository.findById(locationIdStub);

        //Then
        assertNull(location);
    }
}
