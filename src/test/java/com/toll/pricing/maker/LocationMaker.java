package com.toll.pricing.maker;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.toll.pricing.domain.Location;
import com.toll.pricing.domain.Route;

import java.util.Arrays;
import java.util.List;

import static com.natpryce.makeiteasy.MakeItEasy.*;
import static com.natpryce.makeiteasy.Property.newProperty;

public class LocationMaker {

    public static final Property<Location, Long> locationIdProp = newProperty();
    public static final Property<Location, String> nameProp = newProperty();
    public static final Property<Location, List<Route>> routes = newProperty();

    public static final Instantiator<Location> LocationMock = lookup -> Location.builder()
            .locationId(lookup.valueOf(locationIdProp, 1L))
            .name(lookup.valueOf(nameProp, "Location Name"))
            .routes(lookup.valueOf(routes, Arrays.asList(
                    Route.builder()
                            .toLocationId(1L)
                            .distance(0D)
                            .build()
            )))
            .build();

    public static Location aLocation(Long locationId, String name) {
        return make(a(LocationMock, with(locationIdProp, locationId), with(nameProp, name)));
    }
}
