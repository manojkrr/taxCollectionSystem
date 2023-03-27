package com.toll.pricing.controller;

import com.toll.pricing.domain.CostOfTrip;
import com.toll.pricing.service.TollPricingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TollPricingControllerTest {

    @Mock
    private TollPricingService tollPricingService;

    private TollPricingController tollPricingController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tollPricingController = new TollPricingController(tollPricingService);
    }

    @Test
    public void testGetTotalCostOfTrip() {
        // Given
        String entryLocationName = "Entry";
        String exitLocationName = "Exit";
        CostOfTrip expectedCostOfTrip = CostOfTrip.builder()
                .amount(10.0)
                .build();

        when(tollPricingService.getCostOfTrip(entryLocationName, exitLocationName))
                .thenReturn(expectedCostOfTrip);

        // When
        CostOfTrip actualCostOfTrip = tollPricingController.getTotalCostOfTrip(entryLocationName, exitLocationName);

        // Then
        assertEquals(expectedCostOfTrip, actualCostOfTrip);
    }
}
