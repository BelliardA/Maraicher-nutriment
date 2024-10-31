package com.dev6.Webfoodapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login") // Mappage de la page de connexion
    public String login() {
        return "login"; // Retourne le nom de la vue 'login.html'
    }
}
