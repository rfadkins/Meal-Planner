package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.RecipeService;
import com.techelevator.business.UserService;
import com.techelevator.datatransfer.Mapper;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.techelevator.datatransfer.RecipeDTO;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Collections;

@RestController
@CrossOrigin
//@RequestMapping("/recipe")
//@PreAuthorize("isAuthenticated()")
public class RecipeController{
//This controller handles the recipe table

    UserService userService;
    @Autowired
    RecipeService recipeService;
    @Autowired
    Mapper mapper;

    @Autowired
    public RecipeController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

        /*--------------------
        createRecipe()
        POST
        PATH: /recipe/
        --------------------*/
        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/recipe/")
        public void createRecipe(@RequestBody RecipeDTO recipeDTO) {
            Recipe recipe = mapper.mapRecipeDTOToEntity(recipeDTO);
            System.out.println(recipeDTO.getRecipeName() + recipeDTO.getRecipeInstructions() + recipeDTO.getCategory());
            recipeService.createRecipe(recipeDTO.getRecipeName(), recipeDTO.getRecipeInstructions(), recipeDTO.getCategory());
        }

        /*--------------------
        editRecipe()
        PUT
        PATH: /recipe/{recipe_id}
        --------------------*/
        @PutMapping("/recipe/{recipeId}")
        public String editRecipe(@PathVariable("recipeId") Long recipeId, @RequestBody Recipe recipe) {
            return ("Put/edit recipe by ID is not implemented yet. However, I have received a put request for /recipe/" +recipeId);
        }


        /*--------------------
        deleteRecipe()
        DELETE
        PATH: /recipe/{recipe_id}
        --------------------*/
        @DeleteMapping("/recipe/{recipeId}")
        public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
            recipeService.deleteRecipe(recipeId);
        }


        /*--------------------
        displayRecipe()
        GET
        PATH: /recipe/{recipe_id}
        --------------------*/
        @GetMapping("/recipe/{recipeId}")
        public String displayRecipe(@PathVariable("recipeId") Long recipeId) {
            return ("Get recipe by ID is not implemented yet. However, I have received a get request for /recipe/" +recipeId);

        }



        /*--------------------
        displayAllRecipes()
        GET
        PATH: /recipe/
        --------------------*/

    @GetMapping("/recipe/")
    public String displayAllRecipes(@PathVariable("recipeId") Long recipeId) {
        return ("I have received a request to List all recipes, but it is not implemented yet.");

    }



}