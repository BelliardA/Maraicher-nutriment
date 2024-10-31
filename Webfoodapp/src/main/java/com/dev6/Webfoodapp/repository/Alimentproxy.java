package com.dev6.Webfoodapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev6.Webfoodapp.CustomProperties;
import com.dev6.Webfoodapp.model.Aliment;
import com.dev6.Webfoodapp.model.Ingredient;
import com.dev6.Webfoodapp.model.IngredientResponse;
import com.dev6.Webfoodapp.model.Nutrition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Alimentproxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Aliment> getAliments() {
        String baseApiUrl = props.getApiUrl();
        String getAlimentsUrl = baseApiUrl + "/aliments";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Aliment>> response = restTemplate.exchange(
                getAlimentsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Aliment>>() {}
                );

        log.debug("Get Aliments call " + response.getStatusCode().toString());

        System.out.println("Aliments reçus dans le proxy getAliments : " + response.getBody());
        
        return response.getBody();
    }

    public Aliment createAliment(Aliment a){
        System.out.println("Aliment reçu dans le proxy createAliment : " + a);
        String baseApiUrl = props.getApiUrl();
        String createAlimentUrl = baseApiUrl + "/createAliment";

        RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Aliment> response = restTemplate.exchange(
            createAlimentUrl,
            HttpMethod.POST,
            new HttpEntity<>(a),
            Aliment.class
    );
        log.debug("Create Aliment call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteAliment(int id){
        String baseApiUrl = props.getApiUrl();
        String deleteAlimentUrl = baseApiUrl + "/deleteAliment/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Aliment>> response = restTemplate.exchange(
                deleteAlimentUrl,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Iterable<Aliment>>() {}
                );

        log.debug("Delete Aliment call " + response.getStatusCode().toString());
    }


    public Aliment updateAliment(Aliment a){
        String baseApiUrl = props.getApiUrl();
        String updateAlimentUrl = baseApiUrl + "/updateAliment";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Aliment> response = restTemplate.exchange(
                updateAlimentUrl,
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<Aliment>() {}
                );

        log.debug("Update Aliment call " + response.getStatusCode().toString());
        
        return response.getBody();
    }


    public Aliment getAliment(int id){
        String baseApiUrl = props.getApiUrl();
        String getAlimentUrl = baseApiUrl + "/aliment/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Aliment> response = restTemplate.exchange(
                getAlimentUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Aliment>() {}
                );

        log.debug("Get Aliment call " + response.getStatusCode().toString());

        
        return response.getBody();
    }

    
    public Nutrition getNutritionByName(String name) {
    String baseApiUrl = "https://api.spoonacular.com"; // Base URL de Spoonacular
    String apiKey = props.getApiKey(); // Récupérez votre clé API depuis CustomProperties

    // Étape 1: Trouver l'ID de l'aliment
    String findUrl = baseApiUrl + "/food/ingredients/search?query=" + name + "&apiKey=" + apiKey;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<IngredientResponse> findResponse = restTemplate.exchange(
            findUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<IngredientResponse>() {}
    );

    // Vérifiez si l'aliment a été trouvé
    if (findResponse.getBody() != null && findResponse.getBody().getResults() != null && !findResponse.getBody().getResults().isEmpty()) {
        Ingredient ingredient = findResponse.getBody().getResults().get(0); // Prendre le premier résultat
        String ingredientId = ingredient.getId().toString(); // Récupérer l'ID de l'aliment
        // Étape 2: Obtenir les informations nutritionnelles de l'aliment
        String nutritionUrl = baseApiUrl + "/food/ingredients/" + ingredientId + "/information?amount=1&apiKey=" + apiKey;

        System.out.println("URL de l'API pour les informations nutritionnelles : " + nutritionUrl);

        ResponseEntity<Nutrition> nutritionResponse = restTemplate.exchange(
                nutritionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Nutrition>() {}
        );

        return nutritionResponse.getBody();
    } else {
        throw new RuntimeException("Aucun aliment trouvé pour le nom : " + name);
    }
}
}
