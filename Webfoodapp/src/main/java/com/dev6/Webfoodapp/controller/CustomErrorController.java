package com.dev6.Webfoodapp.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error") // Gestion des erreurs
    public String handleError() {
        return "error"; // Retourne le nom de la vue 'error.html'
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
