package com.toll.pricing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Route {
    private Long toLocationId;
    private Double distance;
}
