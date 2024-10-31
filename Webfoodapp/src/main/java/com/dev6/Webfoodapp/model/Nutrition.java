package com.dev6.Webfoodapp.model;

import lombok.Data;
import java.util.List;

@Data
public class Nutrition {
    private int id;
    private String original;
    private String name;
    private double amount;
    private String unit; 
    private NutritionDetails nutrition; 

    @Data
    public static class NutritionDetails { 
        private List<Nutrient> nutrients;
        private WeightPerServing weightPerServing; 
        private CaloricBreakdown caloricBreakdown;
    }

    @Data
    public static class Nutrient {
        private String name;
        private double amount;
        private String unit;
        private double percentOfDailyNeeds;
    }

    @Data
    public static class WeightPerServing {
        private double amount;
        private String unit;
    }

    @Data
    public static class CaloricBreakdown {
        private double percentProtein;
        private double percentFat;
        private double percentCarbs;
    }
}