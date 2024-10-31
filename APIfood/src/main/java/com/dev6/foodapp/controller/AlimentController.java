package com.dev6.foodapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dev6.foodapp.model.Aliment;
import com.dev6.foodapp.service.AlimentService;

@RestController
public class AlimentController {

    @Autowired
    private AlimentService alimentService;

    /**
     * Save an aliment
     * @param aliment
     * @return l'aliment sauvegardé
     */
    @PostMapping("/createAliment")
    public Aliment createAliment(@RequestBody Aliment aliment){
        return alimentService.saveAliment(aliment);
    }

    /**
     * Get all aliments
     * @return les aliments présent dans la base de données
     */

    @GetMapping("/aliments")
    public Iterable<Aliment> getAliments() {
        return alimentService.findAll();
    }

    /**
     * Get an aliment by id
     * @param id
     * @return l'aliment correspondant à l'id
     */
    @GetMapping("/aliment/{id}")
    public Aliment getAliment(@PathVariable("id") final Long id){
        Optional<Aliment> aliment = alimentService.findAliment(id);
        if(aliment.isPresent()){
            return aliment.get();
        }else{
            return null;
        }
    }

    /**
     * Delete an aliment by id
     * @param id
     */
    @DeleteMapping("/deleteAliment/{id}")
    public void deleteAliment(@PathVariable("id") final Long id){
        alimentService.deleteAliment(id);
    }

    /**
     * Update an aliment
     * @param aliment - object aliment
     * @param id - id of the aliment
     * @return
     */
    @PutMapping("/updateAliment/{id}")
    public Aliment updateAliment(@PathVariable("id") final Long id, @RequestBody Aliment aliment){
        Optional<Aliment> a = alimentService.findAliment(id);
        if(a.isPresent()){

            Aliment currentAliment = a.get();

            String name = aliment.getName();
            if(name != null){
                currentAliment.setName(name);
            }
            Integer quantity = aliment.getQuantity();
            if(quantity != null){
                currentAliment.setQuantity(quantity);
            }
            Double price = aliment.getPrice();
            if(price != null){
                currentAliment.setPrice(price);
            }
            Double calories = aliment.getCalories();
            if(calories != null){
                currentAliment.setCalories(calories);
            }

            alimentService.saveAliment(currentAliment);
            return currentAliment;
        } else {
            return null;
        }
    }



}
