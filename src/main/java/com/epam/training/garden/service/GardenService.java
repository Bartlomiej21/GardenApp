package com.epam.training.garden.service;

import com.epam.training.garden.domain.GardenProperties;
import com.epam.training.garden.domain.PlantType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GardenService {
    private GardenProperties gp;

    public GardenService(){}

    public static List<PlantType> getPlantTypes(){
        PlantType corn = new PlantType("corn",0.4,10);
        PlantType pumpkin = new PlantType("pumpkin",2,5);
        PlantType grape = new PlantType("grape",3,5);
        PlantType tomato = new PlantType("tomato",0.3,10);
        PlantType cucumber = new PlantType("cucumber",0.4,10);
        List<PlantType> plants = new ArrayList<>();
        plants.add(corn);
        plants.add(pumpkin);
        plants.add(grape);
        plants.add(tomato);
        plants.add(cucumber);
        return plants;
    }

    public void setGardenProperties(GardenProperties gardenProperties){
        this.gp = gardenProperties;
    }

    public Result evaluatePlan(Map<String, Integer> items) throws IllegalArgumentException{
        // here logic for creating new Result
        // numberOfPlants*area*waterAmount = waterAmountNeededInLiters
        return null;
    }
}
