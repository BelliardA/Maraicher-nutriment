package com.dev6.Webfoodapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev6.Webfoodapp.CustomProperties;
import com.dev6.Webfoodapp.model.Nutrition;

@Component
public class SpoonacularProxy {
    @Autowired
    private CustomProperties props;

    public Nutrition getNutritionByName(String name) {
        String baseApiUrl = "https://api.spoonacular.com"; // Base URL de Spoonacular
        String apiKey = props.getApiKey(); // Récupérez votre clé API depuis CustomProperties
        String url = baseApiUrl + "/food/findByName?name=" + name + "&apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Nutrition> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Nutrition>() {}
        );

        return response.getBody();
    }
}