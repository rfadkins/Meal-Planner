//package com.techelevator.controller;
//
//import com.techelevator.business.*;
//import com.techelevator.model.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@CrossOrigin
////@PreAuthorize("isAuthenticated()")
//public class TestController {
//
//    @Autowired
//    UserOwnershipService userOwnershipService;
//    @Autowired
//    IngredientService ingredientService;
//    @Autowired
//    MealService mealService;
//    @Autowired
//    MealRecipeService mealRecipeService;
//    @Autowired
//    RecipeIngredientService recipeIngredientService;
//    @Autowired
//    MealPlanService mealPlanService;
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping ("/test/ingredient")
//    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
//        //com.techelevator.model.Ingredient ingredient = mapper.mapIngredientDTOToEntity(ingredientDTO);
//        this.ingredientService = ingredientService;
//        return this.ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
//    }
//

//    @GetMapping("/user/")
//    public List<User> getAllUsers() {
//        return userOwnershipService.listAllUsers();
//    }
//



//
//    @GetMapping("/test/ingredient")
//    public List<Ingredient> listIngredients() {
//        return ingredientService.getAllIngredients();
//    }
//
//    @GetMapping("/test/mealplan/")
//    public List<MealPlan> listMealPlans() {
//        return mealPlanService.displayAllMealPlans();
//    }
//
//    @GetMapping("/test/user/pantry/{userId}")
//    public List<Ingredient> displayUserPantry (Long userId) {
//        return userOwnershipService.displayUserPantry(userId);
//    }

//    @GetMapping
//    public List<MealPlan> listMealPlansByUserId(@RequestParam Long userId) {
//        return mealPlanService.displayAllMealPlansByUser(userId);
//    }
//
//    @PostMapping("/recipe/user/{recipeId}/{userId}")
//    public void addRecipeToUser (@PathVariable("recipeId") Long recipeId, @PathVariable("userId") Long userId) {
//        userOwnershipService.addRecipeToUser(recipeId, userId);
//    }
//
//    @GetMapping("/recipe/user/{userId}")
//    public void listUserRecipes (@PathVariable("userId") Long userId) {
//        userOwnershipService.listUserRecipes(userId);
//    }
//
//    @PostMapping ("/ingredient/recipe/{ingredientId}/{recipeId}")
//    public void addIngredientToRecipe(@RequestBody Ingredient ingredient, @PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
//        recipeIngredientService.addIngredientToRecipe(recipeId,ingredientId);
//    }
//
//


//}