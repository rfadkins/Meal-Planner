package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.UserRepository;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }



    public Ingredient createIngredient(String name, String category) {


        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(name);
        ingredient.setIngredientCategory(category);
        ingredientRepository.saveAndFlush(ingredient);

        return ingredient;
    }

    public long deleteIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        String name = ingredient.getIngredientName();

        if(ingredient == null) {

                BasicLogger.log("Ingredient doesn't exist");
            } else {
            ingredientRepository.deleteById(ingredientId);
        }
        return 0;
    }



    public Map<Long, Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId){

        User user = userRepository.findByUserId(userId);
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

        Map<Long, Ingredient> pantry = new HashMap<>();
        pantry.put(user.getUserId(), ingredient);

        user.setUserPantry(pantry);
        userRepository.save(user);

        return pantry;
    }

    public Map<Long, Ingredient> deleteIngredientFromUserPantry(Long userId, Long ingredientId) {
        User user = userRepository.findByUserId(userId);
        Map<Long, Ingredient> pantry = user.getUserPantry();
        pantry.remove(ingredientId);
        user.setUserPantry(pantry);
        return pantry;
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
// RESTTEMPLATE SAVE ------
//        ResponseEntity<Ingredient> response;
//        try {
//            response = restTemplate.exchange
//                    (baseUrl +
//                    "ingredient/" ,
//                    HttpMethod.POST,
//                    createEntity(),
//                    Ingredient.class);
//        } catch (RestClientResponseException e) {
//            BasicLogger.log("status code: " + e.getRawStatusCode() + "   " + e.getMessage());
//        }