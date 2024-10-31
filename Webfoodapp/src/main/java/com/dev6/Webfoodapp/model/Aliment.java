package com.dev6.Webfoodapp.model;

import lombok.Data;

@Data
public class Aliment {

    private Integer id;
    private String name;
    private Integer quantity;
    private double price;
    private double calories;
    private double proteins;
    private double carbohydrates;
    private double lipids;
}
