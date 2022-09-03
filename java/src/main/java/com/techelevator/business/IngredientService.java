package com.techelevator.business;

import com.techelevator.exceptions.*;
import com.techelevator.model.*;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeService recipeService;


    public Ingredient createIngredient(String name, String category) {
        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientName(name);
        ingredient.setIngredientCategory(category);

        ingredientRepository.saveAndFlush(ingredient);

        return ingredient;
    }

    public void deleteIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientRepository.deleteById(ingredientId);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
    }

    public Ingredient getIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return ingredient;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Map<Long, Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId) {
        Map<Long, Ingredient> pantry = new HashMap<>();
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                User user = userRepository.findByUserId(userId);
                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

                pantry.put(user.getUserId(), ingredient);

                user.setXuserPantry(pantry);
                userRepository.save(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }

    public Map<Long, Ingredient> deleteIngredientFromUserPantry(Long userId, Long ingredientId) {
        Map<Long, Ingredient> pantry = new HashMap<>();
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                User user = userRepository.findByUserId(userId);
                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

                pantry = user.getXuserPantry();
                pantry.remove(user.getUserId(), ingredient);

                user.setXuserPantry(pantry);
                userRepository.save(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }

    public List<Ingredient> listIngredientsInPantry(Long userId) {
        Map<Long, Ingredient> pantry = new HashMap<>();
        List<Ingredient> ingredientsInUserPantry = new ArrayList<>();
        try {
            if(userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else{
                User user = userRepository.findByUserId(userId);
                if (user.getXuserPantry() == null) {
                    throw new PantryNotFoundException();
                } else {
                    pantry = user.getXuserPantry();
                    for (Map.Entry<Long, Ingredient> entry : pantry.entrySet()) {
                        ingredientsInUserPantry.add(entry.getValue());
                    }
                }
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return ingredientsInUserPantry;
    }

    public List<Ingredient> makeGroceryListFromRecipeIngredientsAndPantryIngredients(Long userId, Long recipeId) {
        List<Ingredient> groceryList = new ArrayList<>();
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();

            } else if (recipeRepository.findByRecipeId(recipeId) == null) {
                throw new RecipeNotFoundException();

            } else {
                User user = userRepository.findByUserId(userId);
                Recipe recipe = recipeRepository.findByRecipeId(recipeId);

                if (user.getXuserPantry() == null) {
                    throw new PantryNotFoundException();

                } else if (recipe.getRecipeIngredients().isEmpty() || recipe.getRecipeIngredients() == null) {
                    throw new RecipeIngredientsNotFoundException();
                } else {
                    Map<Long, Ingredient> pantry = user.getXuserPantry();
                    Map<Long, Ingredient> recipeIngredients = recipe.getRecipeIngredients();
                   //List<Ingredient> recipeIngredients = recipeService.listIngredientsInRecipe(recipeId);

                    for (Map.Entry<Long, Ingredient> entry : recipeIngredients.entrySet()) {
                        if (!pantry.containsValue(entry)) {
                            groceryList.add(entry.getValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return groceryList;
    }


    //TODO grocery list logic...





    //TODO test getIngredient
    //TODO test getAllIngredients
    //TODO test listIngredientsInUserPantry
    //TODO test listIngredientsInRecipe
}
