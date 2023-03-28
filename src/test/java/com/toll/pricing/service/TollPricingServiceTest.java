package com.toll.pricing.service;

import com.toll.pricing.domain.CostOfTrip;
import com.toll.pricing.domain.Location;
import com.toll.pricing.exception.InvalidLocationException;
import com.toll.pricing.service.impl.TollPricingServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.toll.pricing.maker.LocationMaker.aLocation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TollPricingServiceTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Mock
    private LocationService locationService;
    private TollPricingService tollPricingService;


    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        tollPricingService = new TollPricingServiceImpl(locationService);
    }

    @Test
    public void test_should_calculate_total_charge_between_valid_locations() {
        //Given
        String entryLocationNameStub = "QEW";
        String exitLocationNameStub = "Brock Road";
        Location fromLocation = aLocation(1L, entryLocationNameStub);
        Location toLocation = aLocation(2L, exitLocationNameStub);
        //from location
        when(locationService.getLocationByName(fromLocation.getName()))
                .thenReturn(Optional.of(fromLocation));
        //to location
        when(locationService.getLocationByName(toLocation.getName()))
                .thenReturn(Optional.of(toLocation));
        when(locationService.calculateDistanceInKms(fromLocation, toLocation))
                .thenReturn(30D);

        //When
        CostOfTrip costOfTrip = tollPricingService.getCostOfTrip(entryLocationNameStub, exitLocationNameStub);

        //Then
        assertEquals(30D, costOfTrip.getTotalDistanceInKms());
        assertEquals(7.5D, costOfTrip.getAmount());
    }

    @Test
    public void test_should_throw_exception_when_from_location_is_not_valid() {
        //Given
        String entryLocationNameStub = "QEW";
        String exitLocationNameStub = "Brock Road";
        Location toLocation = aLocation(1L, exitLocationNameStub);
        //from location
        when(locationService.getLocationByName(entryLocationNameStub))
                .thenReturn(Optional.empty());
        //to location
        when(locationService.getLocationByName(exitLocationNameStub))
                .thenReturn(Optional.of(toLocation));

        //Expect Exception
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Invalid Location Id(s)");

        //When
        tollPricingService.getCostOfTrip(entryLocationNameStub, exitLocationNameStub);
    }


    @Test
    public void test_should_throw_exception_when_to_location_is_not_valid() {
        //Given
        String entryLocationNameStub = "QEW";
        String exitLocationNameStub = "Brock Road";

        Location fromLocation = aLocation(1L, entryLocationNameStub);
        //from location
        when(locationService.getLocationByName(entryLocationNameStub))
                .thenReturn(Optional.of(fromLocation));
        //to location
        when(locationService.getLocationByName(exitLocationNameStub))
                .thenReturn(Optional.empty());

        //Expect Exception
        exceptionRule.expect(InvalidLocationException.class);
        exceptionRule.expectMessage("Invalid Location Id(s)");

        //When
        tollPricingService.getCostOfTrip(entryLocationNameStub, exitLocationNameStub);
    }

}
