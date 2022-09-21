//package com.techelevator.business.test;
//
//import com.techelevator.exceptions.RecipeNotFoundException;
//import com.techelevator.model.Meal;
//import com.techelevator.model.Recipe;
//import com.techelevator.model.User;
//import com.techelevator.repository.IngredientRepository;
//import com.techelevator.repository.MealRepository;
//import com.techelevator.repository.RecipeRepository;
//import com.techelevator.repository.UserRepository;
//import com.techelevator.util.BasicLogger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class RecipeService {
//
//    @Autowired
//    private RecipeRepository recipeRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private IngredientRepository ingredientRepository;
//    @Autowired
//    private MealRepository mealRepository;
//
//    //TODO try block w/ exception handling
//    public Recipe createRecipe(String name, String instructions, String category) {
//        Recipe recipe = new Recipe();
//
//        recipe.setRecipeName(name);
//        recipe.setRecipeInstructions(instructions);
//        recipe.setCategory(category);
//
//        try {
//            recipeRepository.saveAndFlush(recipe);
//            System.out.println("Recipe  : " + recipe.getRecipeName() + " has been created.");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            BasicLogger.log(e.getMessage());
//        }
//
//        recipeRepository.saveAndFlush(recipe);
//
//        return recipe;
//    }
//    //TODO try block w/ exception handling
//    public Recipe editRecipe(Long recipeId, String newName, String newInstructions, String newCategory) {
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        recipe.setRecipeName(newName);
//        recipe.setRecipeInstructions(newInstructions);
//        recipe.setCategory(newCategory);
//        recipeRepository.saveAndFlush(recipe);
//        return recipe;
//    }
//
//
//    public void deleteRecipe(Long recipeId) {
//        try {
//            if (recipeRepository.findByRecipeId(recipeId) == null) {
//                throw new RecipeNotFoundException();
//            } else {
//                recipeRepository.delete(recipeRepository.findByRecipeId(recipeId));
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//    }

//    public Set<RecipeIngredient> addIngredientToRecipe(Long recipeId, Long ingredientId, Long count) {
//
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//
//        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, count);
//
//        Set<RecipeIngredient> ingredientsInRecipe = new HashSet<>();
////        ingredientsInRecipe.add(ingredient);
//
//        Set<RecipeIngredient> recipesWithIngredient = new HashSet<>();
////        recipesWithIngredient.add(recipe);
//
////        recipe.setIngredientsInRecipe(ingredientsInRecipe);
////        ingredient.setRecipesWithIngredient(recipesWithIngredient);
//
//        ingredientRepository.saveAndFlush(ingredient);
//        recipeRepository.saveAndFlush(recipe);
//
//        return ingredientsInRecipe;
//    }
//
//    public List<Ingredient> listIngredientsInRecipe(Long recipeId) {
//        List<Ingredient> ingredientsInRecipe = new ArrayList<>();
//        Map<Long, Ingredient> recipeIngredients = new HashMap<>();
//        try {
//            if (recipeRepository.findByRecipeId(recipeId) == null) {
//                throw new RecipeNotFoundException();
//            } else {
//                Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//                if (recipe.getIngredientsInRecipe() == null) {
//                    throw new RecipeIngredientsNotFoundException();
//                } else {
//                    recipeIngredients = recipe.getIngredientsInRecipe();
//                    for (Map.Entry<Long, Ingredient> entry : recipeIngredients.entrySet()) {
//                        ingredientsInRecipe.add(entry.getValue());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return ingredientsInRecipe;
//    }
//
//    public Set<Recipe> addRecipeToUserRecipes(Long userId, Long recipeId) {
//
//        User user = userRepository.findByUserId(userId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//
//        Set<Recipe> userRecipes = new HashSet<>();
//        userRecipes.add(recipeRepository.findByRecipeId(recipeId));
//
//        user.setUserRecipes(userRecipes);
//        userRepository.save(user);
//
//        return userRecipes;
//    }
//
//    public Set<Recipe> addRecipeToMeal(Long mealId, Long recipeId) {
//
//        Meal meal = mealRepository.findByMealId(mealId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//
//        Set<Recipe> mealRecipes = new HashSet<>();
//        mealRecipes.add(recipeRepository.findByRecipeId(recipeId));
//        //TODO fix this setter
////        meal.setMealRecipes(mealRecipes);
////        mealRepository.save(meal);
//
//        return mealRecipes;
//    }
//
//
////TODO displayRecipe()
//    /*--------------------
//    displayRecipe()
//    GET
//    PATH: /recipe/{recipe_id}
//    --------------------*/
//    public Recipe displayRecipe (Long recipeId) {
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        return recipe;
//    }
//
//
//// TODO displayAllRecipes()
//        /*--------------------
//        displayAllRecipes()
//        GET
//        PATH: /recipe/
//        --------------------*/
//    public List<Recipe> displayAllRecipes () {
//        List<Recipe> allRecipes = recipeRepository.findAll();
//        return allRecipes;
//    }
//
//
//    //TODO displayRecipeByCategory()
//    public List<Recipe> displayRecipeByCategory (String category) {
//        List<Recipe> recipesByCategory = recipeRepository.findAllByCategory(category);
//        return recipesByCategory;
//    }
//
////TODO display recipes by name-like
//}
//
//
//
//
//
