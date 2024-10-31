package com.dev6.Webfoodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.dev6.Webfoodapp.model.Aliment;
import com.dev6.Webfoodapp.service.AlimentService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AlimentController {

    @Autowired
    private AlimentService service;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Aliment> aliments = service.getAliments();
        model.addAttribute( "aliments", aliments);
        return "home";
    }

    @GetMapping("/createAliment")
    public String createAliment(Model model){
        Aliment a = new Aliment();
        model.addAttribute(a);
        return "formAddAliment";
    }

    @GetMapping("/updateAliment/{id}")
    public String updateAliment(@PathVariable("id") final int id, Model model){
        Aliment a = service.getAliment(id);
        model.addAttribute(a);
        System.out.println("Aliment reçus : " + a);
        return "formUpdateAliment";
    }

    @GetMapping("/deleteAliment/{id}")
    public ModelAndView deleteAliment(@PathVariable("id") final int id){
        service.deleteAliment(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveAliment")
    public ModelAndView saveAliment(@ModelAttribute Aliment aliment){
        if(aliment.getId() != null){
            Aliment a = service.getAliment(aliment.getId());
            a.setName(aliment.getName());
            a.setCalories(aliment.getCalories());
            a.setPrice(aliment.getPrice());
            a.setQuantity(aliment.getQuantity());
            aliment = a;
        } 
        service.saveAliment(aliment);

        return new ModelAndView("redirect:/");
    }
    
    
    

}
