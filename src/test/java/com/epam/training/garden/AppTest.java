package com.epam.training.garden;

import com.epam.training.garden.domain.GardenProperties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Tests if user input is correct
 *
 * @author Bartłomiej Słomiński
 */
@Test(groups = "user-input")
public class AppTest {
    @DataProvider(name="gardenProperties")
    public Object[][] provideSizeAndWaterSupply(){
        return new Object[][]{
                {0.5,8},
                {0,1.4},
                {1,56},
                {1,1.9},
                {8,10}
        };
    }
    @DataProvider(name="zeroOrNegativeNumbersAsGardenProperties")
    public Object[][] provideBadNumberValues(){
        return new Object[][]{
                {0.5,-8},
                {0,1.4},
                {1,-56},
                {200000,1.9},
                {8,0}
        };
    }
    @DataProvider(name="userPlants")
    public Object[][] providePlantNameAndQuantity(){
        return new Object[][]{
                {"corn,8"},
                {"pumpkin,9"},
                {"grape,67"},
                {"grape,12"},
                {""}
        };
    }
    @DataProvider(name="badUserPlants")
    public Object[][] provideIncorrectPlantNameAndQuantity(){
        return new Object[][]{
                {"corn8"},
                {"pumpkin,ch"},
                {"grape,67/"},
                {"grape,,12"},
        };
    }

    @Test(dataProvider = "gardenProperties")
    public void shouldAcceptProperGardenProperties(double size, double waterSupply) {
        new GardenProperties(size,waterSupply);
    }

    @Test(dataProvider = "zeroOrNegativeNumbersAsGardenProperties",
            expectedExceptions = {IllegalArgumentException.class})
    public void shouldNotAcceptNumberOutsideBoundaries(double size, double waterSupply){
        if ( (size<=0 || waterSupply<=0) || (size>100_000 || waterSupply>100_000) ){
            throw new IllegalArgumentException();
        }
    }

    @Test(dataProvider = "userPlants")
    public void shouldAcceptCorrectPlants(String s) {
        Map<String,Integer> map = new HashMap<>();
        int i = 0;
        while(i<1) {
            if (s.equals("")) break;
            try{
                String[] split = s.split(",");
                map.put(split[0],Integer.parseInt(split[1]));
            } catch (Exception e) {
                System.out.println("Wrong input. Please insert your data according to given format.");
            }
            i++;
        }
    }

    @Test(dataProvider = "badUserPlants", expectedExceptions = {NumberFormatException.class,
            ArrayIndexOutOfBoundsException.class })
    public void shouldNotAcceptIncorrectPlantsData(String s) {
        Map<String,Integer> map = new HashMap<>();
        int i = 0;
        while(i<1) {
            if (s.equals("")) break;
            try{
                String[] split = s.split(",");
                map.put(split[0],Integer.parseInt(split[1]));
            } catch (Exception e) {
                throw e;
            }
            i++;
        }
    }
}
