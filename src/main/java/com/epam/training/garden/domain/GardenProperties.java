package com.epam.training.garden.domain;

public class GardenProperties {
    private double area;
    private double waterSupply;

    public GardenProperties(double area, double waterSupply){
        this.area = area;
        this.waterSupply = waterSupply;
    }

    public double getArea() {
        return area;
    }

    public double getWaterSupply() {
        return waterSupply;
    }
}
