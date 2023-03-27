package com.toll.pricing.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(of = "locationId")
public class Location {
    private Long locationId;
    private String name;
    private List<Route> routes;
}

