package com.toll.pricing.service.impl;

import com.toll.pricing.domain.CostOfTrip;
import com.toll.pricing.domain.Location;
import com.toll.pricing.service.LocationService;
import com.toll.pricing.service.TollPricingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.toll.pricing.utility.FormattingUtility.roundOff;

@Service
@Slf4j
public class TollPricingServiceImpl implements TollPricingService {

    private final LocationService locationService;

    @Autowired
    public TollPricingServiceImpl(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Method to Calculate Toll Charges
     * from entry Location to exit location
     */
    @Override
    public CostOfTrip getCostOfTrip(String entryLocationName, String exitLocationName) {
        Optional<Location> entryLocationOptional = locationService.getLocationByName(entryLocationName);
        Optional<Location> exitLocationOptional = locationService.getLocationByName(exitLocationName);
        if (entryLocationOptional.isEmpty() || exitLocationOptional.isEmpty()) {
            throw new RuntimeException("Invalid Location Id(s)");
        }
        Location entryLocation = entryLocationOptional.get();
        Location exitLocation = exitLocationOptional.get();
        log.info("Calculating Toll for entryLocation={} and exitLocation={}", entryLocation.getName(), exitLocation.getName());
        double totalDistanceInKms = locationService.calculateDistanceInKms(entryLocation, exitLocation);
        double totalAmount = calculateCharge(totalDistanceInKms);
        log.info("Total Charge for using Toll Route from location={} to location={} is={}", entryLocation.getName(), exitLocation.getName(), totalAmount);
        return CostOfTrip.builder()
                .amount(totalAmount)
                .totalDistanceInKms(totalDistanceInKms)
                .build();
    }

    private double calculateCharge(double distanceInKms) {
        double charge = distanceInKms * 0.25D;
        return roundOff(charge,2);
    }
}
