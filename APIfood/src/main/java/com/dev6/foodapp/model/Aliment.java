package com.dev6.foodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "aliment")
public class Aliment {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column (name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "calories")
    private double calories;

    @Column(name = "proteins")
    private double proteins;

    @Column(name = "lipids")
    private double lipids;

    @Column(name = "carbohydrates")
    private double carbohydrates;


}
