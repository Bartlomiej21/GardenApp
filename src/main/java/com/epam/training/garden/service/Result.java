package com.epam.training.garden.service;

public class Result {
    double area;
    double waterAmount;
    boolean areaOk;
    boolean waterOk;

    public Result(double area, double waterAmount, boolean areaOk, boolean waterOk) {
        this.area = area;
        this.waterAmount = waterAmount;
        this.areaOk = areaOk;
        this.waterOk = waterOk;
    }
}
