package com.toll.pricing.service;

import com.toll.pricing.domain.CostOfTrip;

public interface TollPricingService {

    /**
     * Method to calculate total cost of
     * using toll route based on the
     * @param entryLocationName, and
     * @param exitLocationName
     * @return total toll charge including taxes
     * */
    CostOfTrip getCostOfTrip(String entryLocationName, String exitLocationName);
}
