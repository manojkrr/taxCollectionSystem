package com.toll.pricing.repository;

import com.toll.pricing.domain.Location;
import com.toll.pricing.domain.Route;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static com.toll.pricing.utility.FormattingUtility.toDouble;

@Component
public class LocationRepository {

    private final Map<Long, Location> locationMap = new HashMap<>();

    public LocationRepository() {
        loadLocations();
    }

    private void loadLocations() {
        try {
            //Parse the JSON and store values to the HashMap
            InputStream inputStream = new ClassPathResource("interchanges.json").getInputStream();
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(new InputStreamReader(inputStream));
            JSONObject locationsJson = (JSONObject) jsonObj.get("locations");
            for (Object key : locationsJson.keySet()) {
                JSONObject locationJSON = (JSONObject) locationsJson.get(key);
                List<Route> routes = extractRoutes((JSONArray) locationJSON.get("routes"));
                Location location = Location.builder()
                        .locationId(Long.parseLong((String) key))
                        .name((String) locationJSON.get("name"))
                        .routes(routes)
                        .build();
                locationMap.put(location.getLocationId(), location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Route> extractRoutes(JSONArray routesJSON) {
        //Parse the Routes from the JSON
        List<Route> routes = new ArrayList<>();
        for (Object obj : routesJSON) {
            JSONObject routeJSON = (JSONObject) obj;
            Route route = Route.builder()
                    .toLocationId((Long) routeJSON.get("toId"))
                    .distance(toDouble(routeJSON.get("distance")))
                    .build();
            routes.add(route);
        }
        return routes;
    }

    public List<Location> findAll() {
        return new ArrayList<>(locationMap.values());
    }

    public Optional<Location> findByName(String name) {
        return locationMap.values()
                .stream()
                .filter(location -> location.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Location findById(long locationId) {
        return locationMap.get(locationId);
    }
}
