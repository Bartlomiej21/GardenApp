package com.epam.training.garden.domain;

public class PlantType {
    private String name;
    private double area;
    private double waterAmount;

    public PlantType(String name, double area, double waterAmount){
        this.name = name;
        this.area = area;
        this.waterAmount = waterAmount;
    }

    public String getName(){
        return this.name;
    }

    public double getArea(){
        return this.area;
    }

    public double getWaterAmount() {
        return waterAmount;
    }
}
