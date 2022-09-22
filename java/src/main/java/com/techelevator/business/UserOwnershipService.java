package com.techelevator.business;

import com.techelevator.exceptions.*;
import com.techelevator.model.*;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserOwnershipService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MealPlanRepository mealPlanRepository;
    @Autowired
    private UserSavedIngredientsRepository userSavedIngredientsRepository;
    @Autowired
    private UserSavedRecipesRepository userSavedRecipesRepository;
    @Autowired
    private UserSavedMealsRepository userSavedMealsRepository;
    @Autowired
    private UserSavedMealPlansRepository userSavedMealPlansRepository;


    //------------------------------INGREDIENT /  PANTRY------------------------------


    public UserSavedIngredients addIngredientToUserPantry(Long userId, Long ingredientId) {
        UserSavedIngredients userSavedIngredients = new UserSavedIngredients();

        try {
            User user = userRepository.findByUserId(userId);
            Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                userSavedIngredients.setUser(user);
                userSavedIngredients.setIngredient(ingredient);
                userSavedIngredientsRepository.saveAndFlush(userSavedIngredients);
                return userSavedIngredients;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedIngredients;
    }

    public String deleteIngredientFromUserPantry(Long userSavedIngredientId) {
        try {
            UserSavedIngredients userSavedIngredients = userSavedIngredientsRepository.findByUserSavedIngredientsId(userSavedIngredientId);
            if (userSavedIngredients == null) {
                throw new UserSavedIngredientNotFoundException();
            } else {
                String ingredientName = userSavedIngredients.getIngredient().getIngredientName();
                userSavedIngredientsRepository.delete(userSavedIngredients);
                return (ingredientName + " deleted from pantry");
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return "Ingredient not deleted from pantry";
    }

    public List<UserSavedIngredients> displayUserPantry(Long userId) {
        List<UserSavedIngredients> userSavedIngredients = new ArrayList<>();
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                userSavedIngredients = userSavedIngredientsRepository.findAllByUser(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedIngredients;
    }



    //------------------------------RECIPE------------------------------


    public UserSavedRecipes addRecipeToUser (Long userId, Long recipeId) {
        UserSavedRecipes userSavedRecipes = new UserSavedRecipes();

        try {
            User user = userRepository.findByUserId(userId);
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                userSavedRecipes.setUser(user);
                userSavedRecipes.setRecipe(recipe);
                userSavedRecipesRepository.saveAndFlush(userSavedRecipes);
                return userSavedRecipes;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedRecipes;
    }

    public String deleteUserSavedRecipe(Long userSavedRecipeId) {
        try {
            UserSavedRecipes userSavedRecipes = userSavedRecipesRepository.findByUserSavedRecipesId(userSavedRecipeId);
            if (userSavedRecipes == null) {
                throw new UserSavedRecipeNotFoundException();
            } else {
                String recipeName = userSavedRecipes.getRecipe().getRecipeName();
                userSavedRecipesRepository.delete(userSavedRecipes);
                return (recipeName + " deleted from saved recipes");
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return "Recipe not deleted from saved recipes";
    }

    public List<UserSavedRecipes> displayUserSavedRecipes(Long userId) {
        List<UserSavedRecipes> userSavedRecipes = new ArrayList<>();
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                userSavedRecipes = userSavedRecipesRepository.findAllByUser(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedRecipes;
    }



    //------------------------------MEAL------------------------------


    public List<UserSavedMeals> displayUserSavedMeals(Long userId) {

        List<UserSavedMeals> userSavedMeals = new ArrayList<>();
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                userSavedMeals = userSavedMealsRepository.findAllByUser(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedMeals;
    }

    public UserSavedMeals addMealToUser(Long userId, Long mealId) {

        UserSavedMeals userSavedMeal = new UserSavedMeals();
        try {
            User user = userRepository.findByUserId(userId);
            Meal meal = mealRepository.findByMealId(mealId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                userSavedMeal.setUser(user);
                userSavedMeal.setMeal(meal);
                userSavedMealsRepository.saveAndFlush(userSavedMeal);
                return userSavedMeal;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedMeal;
    }

    public String deleteUserSavedMeal(Long userSavedMealId) {
        try {
            UserSavedMeals userSavedMeals = userSavedMealsRepository.findByUserSavedMealsId(userSavedMealId);
            if (userSavedMeals == null) {
                throw new UserSavedMealNotFoundException();
            } else {
                String mealName = userSavedMeals.getMeal().getMealName();
                userSavedMealsRepository.delete(userSavedMeals);
                return (mealName + " deleted from saved meals");
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return "Meal not deleted from saved meals";
    }



    //------------------------------MEAL PLAN------------------------------


    public UserSavedMealPlans addMealPlanToUser(Long userId, Long mealPlanId) {

        UserSavedMealPlans userSavedMealPlan = new UserSavedMealPlans();
        try {
            User user = userRepository.findByUserId(userId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                userSavedMealPlan.setUser(user);
                userSavedMealPlan.setMealPlan(mealPlan);
                userSavedMealPlansRepository.saveAndFlush(userSavedMealPlan);
                return userSavedMealPlan;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedMealPlan;
    }

    public String removeMealPlanFromUser(Long userSavedMealPlanId) {
        try {
            UserSavedMealPlans userSavedMealPlan = userSavedMealPlansRepository.findByUserSavedMealPlansId(userSavedMealPlanId);
            if (userSavedMealPlan == null) {
                throw new UserSavedMealPlanNotFoundException();
            } else {
                userSavedMealPlansRepository.delete(userSavedMealPlan);
                String name = userSavedMealPlan.getMealPlan().getMealPlanName();
                return (name + " Meal Plan removed from user");
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return "Meal Plan not removed from user";
    }

    public List<UserSavedMealPlans> displayUserSavedMealPlans(Long userId) {

        List<UserSavedMealPlans> userSavedMealPlans = new ArrayList<>();
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                userSavedMealPlans = userSavedMealPlansRepository.findAllByUser(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedMealPlans;
    }






}
