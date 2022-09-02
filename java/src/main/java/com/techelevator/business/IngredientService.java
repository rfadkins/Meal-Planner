package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    IngredientRepository ingredientRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }



    public Ingredient createIngredient(String name, String category) {
        String baseUrl = "http://localhost:8080/api";

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(name);
        ingredient.setIngredientCategory(category);
        ingredientRepository.save(ingredient);

        ResponseEntity<Ingredient> response;
        try {
            response = restTemplate.exchange
                    (baseUrl +
                    "ingredient/" ,
                    HttpMethod.POST,
                    createEntity(),
                    Ingredient.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log("status code: " + e.getRawStatusCode() + "   " + e.getMessage());
        }

        return ingredient;
    }

    public List<Ingredient> addIngredient(Ingredient ingredient, List<Ingredient> listOfIngredients){
        listOfIngredients.add(ingredient);
        return listOfIngredients;
    }

    public List<Ingredient> removeIngredient(Ingredient ingredient, List<Ingredient> listOfIngredients){
        listOfIngredients.remove(ingredient);
        return listOfIngredients;
    }


    private HttpHeaders createHeader() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return headers;
    }

    private HttpEntity createEntity() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<String>(headers);
    }


}
