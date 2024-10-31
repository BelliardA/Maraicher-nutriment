package com.dev6.Webfoodapp.model;
import lombok.Data;
import java.util.List;

@Data
public class IngredientResponse {
    private List<Ingredient> results;
    private int offset;
    private int number;
    private int totalResults;
}
