package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;


public class VehicleLocationService {

    private final Map<String, City> cities;

    public VehicleLocationService() {
        this.cities = new HashMap<>();
    }

    private boolean citiesOverlap(City newCity, City existingCity) {
       return !(newCity.getMaxX() < existingCity.getMinX() ||
                newCity.getMinX() > existingCity.getMaxX() ||
                newCity.getMaxY() < existingCity.getMinY() ||
                newCity.getMinY() > existingCity.getMaxY());
    }

    public void addCity(String cityName, Point[] coordinates) {
        City newCity = new City(cityName, coordinates);

        for (City existingCity : cities.values()) {
            if (citiesOverlap(newCity, existingCity)) {
                throw new IllegalArgumentException("City:- " + cityName + " overlaps with existing city:- " + existingCity.getName());
            }
        }

        cities.put(cityName, newCity);
    }

    public boolean isPointInCity(String cityName, int latitude, int longitude) {
        City city = cities.get(cityName);
        if (city == null) {
            throw new IllegalArgumentException("City not found: " + cityName);
        }

        return latitude >= city.getMinX() && latitude <= city.getMaxX() &&
                longitude >= city.getMinY() && longitude <= city.getMaxY();
    }
}
