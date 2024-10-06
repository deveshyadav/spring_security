/*package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleLocationServiceTest {

    private VehicleLocationService locationService;

    @BeforeEach
    public void setUp() {
        locationService = new VehicleLocationService();
    }

    @Test
    public void testAddCityAndCheckPointInCity() {
        Point[] coordinates = {
                new Point(50, 50),
                new Point(50, 60),
                new Point(60, 60),
                new Point(60, 50)
        };

        locationService.addCity("Test City", coordinates);

        // in city
        assertTrue(locationService.isPointInCity("Test City", 55, 55), "Point (55, 55) should be inside Test City");
        assertTrue(locationService.isPointInCity("Test City", 50, 60), "Point (50, 60) should be inside Test City");

        // outside the city
        assertFalse(locationService.isPointInCity("Test City", 61, 61), "Point (61, 61) should be outside Test City");
        assertFalse(locationService.isPointInCity("Test City", 49, 49), "Point (49, 49) should be outside Test City");
    }

    @Test
    public void testAddCityAndCheckPointInCityInvalid() {
        Point[] coordinates = {
                new Point(50, 50),
                new Point(50, 60),
                new Point(60, 60),
                new Point(60, 50)
        };

        locationService.addCity("Test City", coordinates);

        // in city
        assertTrue(locationService.isPointInCity("Test City", 50, 50), "Point (55, 55) should be inside Test City");
        assertTrue(locationService.isPointInCity("Test City", 50, 60), "Point (50, 60) should be inside Test City");

        // outside the city
        assertFalse(locationService.isPointInCity("Test City", 61, 61), "Point (61, 61) should be outside Test City");
        assertFalse(locationService.isPointInCity("Test City", 49, 49), "Point (49, 49) should be outside Test City");
    }

    @Test
    public void testBoundaryPoints() {
        Point[] coordinates = {
                new Point(50, 50),
                new Point(50, 60),
                new Point(60, 60),
                new Point(60, 50)
        };

        locationService.addCity("Test City", coordinates);

        // Points on the boundaries
        assertTrue(locationService.isPointInCity("Test City", 50, 50), "Point (50, 50) should be inside Test City");
        assertTrue(locationService.isPointInCity("Test City", 60, 50), "Point (60, 50) should be inside Test City");
        assertTrue(locationService.isPointInCity("Test City", 50, 60), "Point (50, 60) should be inside Test City");
        assertTrue(locationService.isPointInCity("Test City", 60, 60), "Point (60, 60) should be inside Test City");
    }

    @Test
    public void testOverlappingCities() {
        Point[] coordinatesA = {
                new Point(50, 50),
                new Point(50, 60),
                new Point(60, 60),
                new Point(60, 50)
        };

        Point[] coordinatesB = {
                new Point(55, 55),
                new Point(55, 65),
                new Point(65, 65),
                new Point(65, 55)
        };

        locationService.addCity("City A", coordinatesA);

        // This should throw an exception or a custom handling depending on your implementation
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            locationService.addCity("City B", coordinatesB);
        });
        assertEquals("City:- City B overlaps with existing city:- City A", exception.getMessage());
    }

    @Test
    public void testNullInputs() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            locationService.isPointInCity(null, 55, 55);
        });
        assertEquals("City not found: null", exception.getMessage());
    }

    @Test
    public void testAdjacentPoints() {
        Point[] coordinates = {
                new Point(50, 50),
                new Point(50, 60),
                new Point(60, 60),
                new Point(60, 50)
        };

        locationService.addCity("Test City", coordinates);

        // Points just outside the city
        assertFalse(locationService.isPointInCity("Test City", 49, 59), "Point (50, 59) should be outside Test City");
        assertFalse(locationService.isPointInCity("Test City", 60, 61), "Point (60, 61) should be outside Test City");
        assertFalse(locationService.isPointInCity("Test City", 61, 55), "Point (61, 55) should be outside Test City");
        assertFalse(locationService.isPointInCity("Test City", 49, 55), "Point (49, 55) should be outside Test City");
    }

    @Test
    public void testAddCityNullCoordinates() {

        // This should throw an exception or a custom handling depending on your implementation
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            locationService.addCity("City A", null);
        });
        assertEquals("Invalid city points/A city must have exactly 4 corner points.", exception.getMessage());
    }

    @Test
    public void testInvalidCityCoordinates() {
        // Test with less than 4 coordinates
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Point[] coordinates = {
                    new Point(50, 50),
                    new Point(50, 60)
            };
            locationService.addCity("Invalid City", coordinates);
        });
        assertEquals("Invalid city points/A city must have exactly 4 corner points.", exception.getMessage());

        // Test with more than 4 coordinates
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Point[] coordinates = {
                    new Point(50, 50),
                    new Point(50, 60),
                    new Point(60, 60),
                    new Point(60, 50),
                    new Point(70, 70) // Extra point
            };
            locationService.addCity("Invalid City", coordinates);
        });
        assertEquals("Invalid city points/A city must have exactly 4 corner points.", exception.getMessage());
    }



    @Test
    public void testCityNotFound() {
        // Test with a city that has not been added
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            locationService.isPointInCity("Unknown City", 55, 55);
        });
        assertEquals("City not found: Unknown City", exception.getMessage());
    }
}*/
