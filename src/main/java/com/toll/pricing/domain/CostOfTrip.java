package com.toll.pricing.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CostOfTrip {
    private final Double amount;
    private final Double totalDistanceInKms;
}
