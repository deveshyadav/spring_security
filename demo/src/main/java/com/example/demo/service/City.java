package com.example.demo.service;

import java.awt.*;

public class City {
    private final String name;
    private final Point bottomLeft;
    private final Point topLeft;
    private final Point topRight;
    private final Point bottomRight;

    public City(String name, Point[] corners) {
        if (corners == null || corners.length != 4) {
            throw new IllegalArgumentException("Invalid city points/A city must have exactly 4 corner points.");
        }
        this.name = name;

        // Assign points directly assuming the correct order
        this.bottomLeft = corners[0];
        this.topLeft = corners[1];
        this.topRight = corners[2];
        this.bottomRight = corners[3];
    }

    public String getName() {
        return name;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    // Getters for easier boundary checks
    public int getMinX() {
        return bottomLeft.getX(); // X coordinate of bottom-left point
    }

    public int getMaxX() {
        return bottomRight.getX(); // X coordinate of bottom-right point
    }

    public int getMinY() {
        return bottomLeft.getY(); // Y coordinate of bottom-left point
    }

    public int getMaxY() {
        return topLeft.getY(); // Y coordinate of top-left point
    }

    // Check if a point is inside the city's boundaries
    public boolean containsPoint(Point point) {
        int x = point.getX();
        int y = point.getY();

        return x >= getMinX() && x <= getMaxX() && y >= getMinY() && y <= getMaxY();
    }
}
