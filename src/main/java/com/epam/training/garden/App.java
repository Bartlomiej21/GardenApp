package com.epam.training.garden;

import com.epam.training.garden.domain.GardenProperties;
import com.epam.training.garden.service.GardenService;
import com.epam.training.garden.service.Result;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static GardenProperties collectGardenInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your garden properties.");
        double size, waterSupply;
        try {
            System.out.print("Size (square meter): ");
            size = sc.nextDouble();
            System.out.print("Water supply (in liter): ");
            waterSupply = sc.nextDouble();
            if ((size<=0 || waterSupply<=0) || (size>100_000 || waterSupply>100_000)){
                throw new IllegalArgumentException("Please check if the number provided is valid.");
            }
            return new GardenProperties(size,waterSupply);
        } catch (Exception e){
            throw new InputMismatchException("Input was incorrect (not a number), so the program will now close.");
        }
    }

    static Map<String, Integer> collectPlantsInput(){
        Map<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String message = """
                Known plant types:
                - Corn
                - Pumpkin
                - Grape
                - Tomato
                - Cucumber
                """;
        System.out.println(message);
        System.out.println("Please enter the plants you would like to put in your garden. " +
                "Press enter when you are done.");
      while(true) {
          System.out.println("Enter plant (format: name,amount): ");
          String s = sc.nextLine().toLowerCase();
          if (s.equals("")) break;
          try{
              String[] split = s.split(",");
              map.put(split[0],Integer.parseInt(split[1]));
          } catch (Exception e) {
              System.out.println("Wrong input. Please insert your data according to given format.");
          }
        }
        System.out.println(map.keySet());
        return map;
    }

    public static void main(String[] args) {
        System.out.println("***Welcome to Garden Planner***\n");
        var gs = new GardenService();
        gs.setGardenProperties(collectGardenInput());
        Result result = gs.evaluatePlan(collectPlantsInput());


        System.out.println("OK");
    }
}
