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
            e.getMessage();
            e.printStackTrace();
        }
        return userSavedIngredients;
    }

    public void deleteIngredientFromUserPantry(Long userId, Long userSavedIngredientId) {


        try {
            User user = userRepository.findByUserId(userId);
            UserSavedIngredients userSavedIngredients = userSavedIngredientsRepository.findByUserAndIngredient_ingredientId(user, userSavedIngredientId);
            if (userSavedIngredients == null) {
                throw new UserSavedIngredientNotFoundException();
            } else {
                String ingredientName = userSavedIngredients.getIngredient().getIngredientName();
                userSavedIngredientsRepository.delete(userSavedIngredients);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }


    public UserSavedIngredients editUserSavedIngredient(Long userId, Long ingredientId, Long userSavedIngredientId) {

        UserSavedIngredients userSavedIngredientsToEdit = new UserSavedIngredients();
        try {
            userSavedIngredientsToEdit = userSavedIngredientsRepository.findByUserSavedIngredientsId(userSavedIngredientId);
            if (userSavedIngredientsToEdit == null) {
                throw new UserSavedIngredientNotFoundException();
            } else {
                userSavedIngredientsToEdit.setUser(userRepository.findByUserId(userId));
                userSavedIngredientsToEdit.setIngredient(ingredientRepository.findByIngredientId(ingredientId));
                userSavedIngredientsRepository.saveAndFlush(userSavedIngredientsToEdit);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return userSavedIngredientsToEdit;
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
            e.getMessage();
            e.printStackTrace();
        }
        return userSavedIngredients;
    }

    public UserSavedIngredients getUserSavedIngredientById(Long userSavedIngredientId) {
        UserSavedIngredients userSavedIngredients = new UserSavedIngredients();
        try {
            userSavedIngredients = userSavedIngredientsRepository.findByUserSavedIngredientsId(userSavedIngredientId);
            if (userSavedIngredients == null) {
                throw new UserSavedIngredientNotFoundException();
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
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


    public void deleteUserSavedRecipe(Long userSavedRecipeId) {
        try {
            UserSavedRecipes userSavedRecipes = userSavedRecipesRepository.findByUserSavedRecipesId(userSavedRecipeId);
            if (userSavedRecipes == null) {
                throw new UserSavedRecipeNotFoundException();
            } else {
                String recipeName = userSavedRecipes.getRecipe().getRecipeName();
                userSavedRecipesRepository.delete(userSavedRecipes);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
    }



    public UserSavedRecipes editUserSavedRecipe(Long userId, Long recipeId, Long userSavedRecipeId) {

        UserSavedRecipes userSavedRecipesToEdit = new UserSavedRecipes();
        try {
            userSavedRecipesToEdit = userSavedRecipesRepository.findByUserSavedRecipesId(userSavedRecipeId);
            if (userSavedRecipesToEdit == null) {
                throw new UserSavedRecipeNotFoundException();
            } else {
                userSavedRecipesToEdit.setUser(userRepository.findByUserId(userId));
                userSavedRecipesToEdit.setRecipe(recipeRepository.findByRecipeId(recipeId));
                userSavedRecipesRepository.saveAndFlush(userSavedRecipesToEdit);

            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedRecipesToEdit;
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

    public UserSavedRecipes getUserSavedRecipe(Long userSavedRecipeId) {
        try {
            UserSavedRecipes userSavedRecipes = userSavedRecipesRepository.findByUserSavedRecipesId(userSavedRecipeId);
            if (userSavedRecipes == null) {
                throw new UserSavedRecipeNotFoundException();
            } else {
                return userSavedRecipes;
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }



    //------------------------------MEAL------------------------------


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


    public UserSavedMeals editUserSavedMeal(Long userId, Long mealId, Long userSavedMealId) {

        UserSavedMeals userSavedMealsToEdit = new UserSavedMeals();
        try {
            userSavedMealsToEdit = userSavedMealsRepository.findByUserSavedMealsId(userSavedMealId);
            if (userSavedMealsToEdit == null) {
                throw new UserSavedMealNotFoundException();
            } else {
                userSavedMealsToEdit.setUser(userRepository.findByUserId(userId));
                userSavedMealsToEdit.setMeal(mealRepository.findByMealId(mealId));
                userSavedMealsRepository.saveAndFlush(userSavedMealsToEdit);
                return userSavedMealsToEdit;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedMealsToEdit;
    }

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

    public UserSavedMeals getUserSavedMeals(Long userSavedMealId) {
        try {
            UserSavedMeals userSavedMeals = userSavedMealsRepository.findByUserSavedMealsId(userSavedMealId);
            if (userSavedMeals == null) {
                throw new UserSavedMealNotFoundException();
            } else {
                return userSavedMeals;
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return null;
        }
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

    public void deleteMealPlanFromUser(Long userSavedMealPlanId) {
        try {
            UserSavedMealPlans userSavedMealPlan = userSavedMealPlansRepository.findByUserSavedMealPlansId(userSavedMealPlanId);
            if (userSavedMealPlan == null) {
                throw new UserSavedMealPlanNotFoundException();
            } else {
                userSavedMealPlansRepository.delete(userSavedMealPlan);
                String name = userSavedMealPlan.getMealPlan().getMealPlanName();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
    }

    public UserSavedMealPlans editUserSavedMealPlan(Long userId, Long mealPlanId, Long userSavedMealPlanId) {

        UserSavedMealPlans userSavedMealPlanToEdit = new UserSavedMealPlans();
        try {
            userSavedMealPlanToEdit = userSavedMealPlansRepository.findByUserSavedMealPlansId(userSavedMealPlanId);
            User user = userRepository.findByUserId(userId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);

            if (userSavedMealPlanToEdit == null) {
                throw new UserSavedMealPlanNotFoundException();
            } else if (user == null) {
                throw new UserNotFoundException();
            } else if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                userSavedMealPlanToEdit.setUser(userRepository.findByUserId(userId));
                userSavedMealPlanToEdit.setMealPlan(mealPlanRepository.findByMealPlanId(mealPlanId));
                userSavedMealPlansRepository.saveAndFlush(userSavedMealPlanToEdit);

                return userSavedMealPlanToEdit;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userSavedMealPlanToEdit;
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

    public UserSavedMealPlans getUserSavedMealPlan(Long userSavedMealPlanId) {
        try {
            UserSavedMealPlans userSavedMealPlan = userSavedMealPlansRepository.findByUserSavedMealPlansId(userSavedMealPlanId);
            if (userSavedMealPlan == null) {
                throw new UserSavedMealPlanNotFoundException();
            } else {
                return userSavedMealPlan;
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }





}
