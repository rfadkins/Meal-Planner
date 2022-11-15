package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserOwnershipService;
import com.techelevator.business.UserService;
import com.techelevator.exceptions.*;
import com.techelevator.model.*;
import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class userOwnershipController{

//imports

    @Autowired
    UserService userService;
    @Autowired
    UserOwnershipService userOwnershipService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    MealRepository mealRepository;
    @Autowired
    MealPlanRepository mealPlanRepository;
    @Autowired
    UserSavedIngredientsRepository userSavedIngredientsRepository;
    @Autowired
    UserSavedRecipesRepository userSavedRecipesRepository;
    @Autowired
    UserSavedMealsRepository userSavedMealsRepository;
    @Autowired
    UserSavedMealPlansRepository userSavedMealPlansRepository;

    @Autowired
    public void UserOwnershipController (UserService userService, UserOwnershipService userOwnershipService) {
        this.userService = userService;
        this.userOwnershipService = userOwnershipService;
    }



/*
-----------------------------------USER STUFF-----------------------------------
Get User by ID                      /user/id/{userId}
Get User by Username                /user/username/{username}
Get All Users                       /user/  ** (ADMIN ONLY)? **
*/
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/id/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                return user;
            }
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
}
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/username/{userName}")
    public User getUserByUsername(@PathVariable("userName") String userName) {
        try {
            User user = userRepository.findByUsername(userName);
            if (user == null) {
                throw new UserNotFoundException();
            } else {
                return user;
            }
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.listAllUsers();
    }


/*
------------------------------INGREDIENT /  PANTRY------------------------------
Add ingredient to pantry            /user/pantry/add{userId}/{ingredientId}
Delete ingredient from pantry       /user/pantry/delete/{userSavedIngredientsId}
Edit UserSavedIngredient            /user/ingredient/pantry/edit/{userId}/{ingredientId}/{userIngredientId}
Get all ingredients in pantry       /user/pantry/all/{userId}
Get specific ingredient in pantry   /user/pantry/get/{userSavedIngredientsId}
*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/user/pantry/add{userId}/{ingredientId}")
    public UserSavedIngredients addIngredientToPantry(@PathVariable ("userId") Long userId,
                                                    @PathVariable ("ingredientId") Long ingredientId) {
        try {
            Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
            User user = userRepository.findByUserId(userId);
            if (user == null){
                throw new UserNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                return userOwnershipService.addIngredientToUserPantry(userId, ingredientId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/user/pantry/delete/{userId}/{ingredientId}")
    public void deleteIngredientFromUserPantry(@PathVariable("userId") Long userId,
                                                @PathVariable("ingredientId") Long ingredientId) {
        try {
            User user = userRepository.findByUserId(userId);
            UserSavedIngredients userSavedIngredients = userSavedIngredientsRepository.findByUserAndIngredient_ingredientId(user, ingredientId);
            if (userSavedIngredients == null){
                throw new UserSavedIngredientNotFoundException();
            } else {
                userOwnershipService.deleteIngredientFromUserPantry(userId, ingredientId);
            }
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping ("/user/ingredient/pantry/edit/{userId}/{ingredientId}")
    public UserSavedIngredients editIngredientFromUserPantry(@PathVariable ("userId") Long userId,
                                                            @PathVariable ("ingredientId") Long ingredientId) {
        try {
            User user = userRepository.findByUserId(userId);
            Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                UserSavedIngredients userSavedIngredients = userSavedIngredientsRepository.findByUserAndIngredient_ingredientId(user, ingredientId);
                return userOwnershipService.editUserSavedIngredient(userId, ingredientId, userSavedIngredients.getUserSavedIngredientsId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/pantry/all/{userId}")
    public List<UserSavedIngredients> listUserPantry(@PathVariable ("userId") Long userId) {
        try {
            List<UserSavedIngredients> userSavedIngredients = userSavedIngredientsRepository.findAllByUser
                    (userService.findByUserId(userId));
            if (userSavedIngredients == null){
                throw new UserSavedIngredientNotFoundException();
            } else {
                return this.userOwnershipService.displayUserPantry(userId);
            }
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/pantry/get/{userId}/{ingredientId}")
    public UserSavedIngredients getUserSavedIngredientById(@PathVariable("userId") Long userId,
                                                            @PathVariable("ingredientId") Long ingredientId) {
        try {
            User user = userRepository.findByUserId(userId);
            Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

            if (user == null){
                throw new UserSavedIngredientNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                UserSavedIngredients userSavedIngredients = userSavedIngredientsRepository.findByUserAndIngredient_ingredientId(user, ingredientId);
                return userSavedIngredients;
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


/*
-------------------------------------RECIPE-------------------------------------
Add recipe to user                  /user/recipe/add/{userId}/{recipeId}
Delete recipe from user             /user/recipe/delete/{userId}/{recipeId}
Edit UserSavedRecipe                /user/recipe/edit/{userId}/{recipeId}
Get all of User's recipes           /user/recipe/all/{userId}
Get specific User's recipe          /user/recipe/get/{userId}/{recipeId}

*/
@ResponseStatus(HttpStatus.CREATED)
@PostMapping ("/user/recipe/add/{userId}/{recipeId}")
public UserSavedRecipes addRecipeToUser(@PathVariable ("userId") Long userId,
                                        @PathVariable ("recipeId") Long recipeId) {
    try {
        User user = userRepository.findByUserId(userId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        if (user == null) {
            throw new UserNotFoundException();
        } else if (recipe == null) {
            throw new RecipeNotFoundException();
        } else {
            return this.userOwnershipService.addRecipeToUser(userId, recipeId);
        }
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
    }
}

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/user/recipe/delete/{userId}/{recipeId}")
    public void deleteRecipeFromUser(@PathVariable ("userId") Long userId,
                                    @PathVariable ("recipeId") Long recipeId) {
        try {
            User user = userRepository.findByUserId(userId);
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);

            if (user == null){
                throw new UserNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                UserSavedRecipes userSavedRecipe = userSavedRecipesRepository.findByUserAndRecipe_recipeId(user, recipeId);
                userOwnershipService.deleteUserSavedRecipe(userSavedRecipe.getUserSavedRecipesId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping ("/user/recipe/edit/{userId}/{recipeId}")
    public UserSavedRecipes editUserSavedRecipe(@PathVariable ("userId") Long userId,
                                                @PathVariable ("recipeId") Long recipeId) {
        try {
            User user = userRepository.findByUserId(userId);
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);
            if (user == null){
                throw new UserSavedRecipeNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                UserSavedRecipes userSavedRecipeToEdit = userSavedRecipesRepository.findByUserAndRecipe_recipeId(user, recipeId);
                return userSavedRecipeToEdit;
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/recipe/get/{userId}/{recipeId}")
    public UserSavedRecipes getUserSavedRecipe(@PathVariable ("userId") Long userId,
                                                @PathVariable ("recipeId") Long recipeId) {
        try {
            User user = userRepository.findByUserId(userId);
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);

            if (user == null){
                throw new UserSavedRecipeNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                UserSavedRecipes userSavedRecipe = userSavedRecipesRepository.findByUserAndRecipe_recipeId(user, recipeId);
                return this.userOwnershipService.getUserSavedRecipe(userSavedRecipe.getUserSavedRecipesId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/recipe/all/{userId}")
    public List<UserSavedRecipes> listAllUserRecipes(@PathVariable ("userId") Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null){
                throw new UserNotFoundException();
            } else {
                return this.userOwnershipService.displayUserSavedRecipes(userId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


/*
--------------------------------------MEAL--------------------------------------
Add meal to user                    /user/meal/add/{userId}/{mealId}
Delete meal from user               /user/meal/delete/{userId}/{mealId}
Edit UserSavedMeal                  /user/meal/edit/{userId}/{mealId}/{userMealId}
Get all of User's meals             /user/meal/all/{userId}
Get specific User's meal            /user/meal/get/{userSavedMealId}

*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/user/meal/add/{userId}/{mealId}")
    public UserSavedMeals addMealToUser(@PathVariable("userId") Long userId,
                                        @PathVariable("mealId") Long mealId) {
        try {
            User user = userRepository.findByUserId(userId);
            Meal meal = mealRepository.findByMealId(mealId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                return this.userOwnershipService.addMealToUser(userId, mealId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/user/meal/delete/{userId}/{mealId}")
    public void removeMealFromUser(@PathVariable("userId") Long userId,
                                    @PathVariable("mealId") Long mealId) {
        try {
            User user = userRepository.findByUserId(userId);
            Meal meal = mealRepository.findByMealId(mealId);
            if (user == null){
                throw new UserSavedMealNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                UserSavedMeals userSavedMeal = userSavedMealsRepository.findByUserAndMeal_mealId(user, mealId);
                userOwnershipService.deleteUserSavedMeal(userSavedMeal.getUserSavedMealsId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping ("/user/meal/edit/{userId}/{mealId}")
    public UserSavedMeals editUserSavedMeal(@PathVariable ("userId") Long userId,
                                            @PathVariable ("mealId") Long mealId) {
        try {
            User user = userRepository.findByUserId(userId);
            Meal meal = mealRepository.findByMealId(mealId);
            if (user == null){
                throw new UserNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                UserSavedMeals userSavedMealToEdit = userSavedMealsRepository.findByUserAndMeal_mealId(user, mealId);
                return this.userOwnershipService.editUserSavedMeal(userId, mealId, userSavedMealToEdit.getUserSavedMealsId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/meal/all/{userId}")
    public List<UserSavedMeals> displayMyMeals(@PathVariable ("userId") Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null){
                throw new UserNotFoundException();
            } else {
                return this.userOwnershipService.displayUserSavedMeals(userId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/meal/get/{userId}/{mealId}")
    public UserSavedMeals getUserSavedMeal(@PathVariable ("userId") Long userId,
                                            @PathVariable ("mealId") Long mealId) {
        try {
            User user = userRepository.findByUserId(userId);
            Meal meal = mealRepository.findByMealId(mealId);
            if (user == null){
                throw new UserSavedMealNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                UserSavedMeals userSavedMeal = userSavedMealsRepository.findByUserAndMeal_mealId(user, mealId);
                return this.userOwnershipService.getUserSavedMeals(userSavedMeal.getUserSavedMealsId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


/*
-----------------------------------MEAL PLAN------------------------------------
Add meal plan to user               /user/mealplan/add/{userId}/{mealPlanId}
Delete meal plan from user          /user/mealplan/delete/{userId}/{mealPlanId}
Edit UserSavedMealPlan              /user/mealplan/edit/{userId}/{mealPlanId}
Get all of User's meal plans        /user/mealplan/all/{userId}

*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/user/mealplan/add/{userId}/{mealplanId}")
    public UserSavedMealPlans addUserToMealPlan(@PathVariable("userId") Long userId,
                                                @PathVariable("mealplanId") Long mealPlanId) {
        try {
            User user = userRepository.findByUserId(userId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                return this.userOwnershipService.addMealPlanToUser(userId, mealPlanId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/user/mealplan/delete/{userId}/{mealPlanId}")
    public void deleteMealPlanFromUser(@PathVariable ("userId") Long userId,
                                        @PathVariable ("mealPlanId") Long mealPlanId) {
        try {
            User user = userRepository.findByUserId(userId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            if (user == null){
                throw new UserSavedMealPlanNotFoundException();
            } else if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                UserSavedMealPlans userSavedMealPlan = userSavedMealPlansRepository.findByUserAndMealPlan_mealPlanId(user, mealPlanId);
                userOwnershipService.deleteMealPlanFromUser(userSavedMealPlan.getUserSavedMealPlansId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping ("/user/mealplan/edit/{userId}/{mealPlanId}")
    public UserSavedMealPlans editUserSavedMealPlan(@PathVariable ("userId") Long userId,
                                                    @PathVariable ("mealPlanId") Long mealPlanId) {
        try {
            User user = userRepository.findByUserId(userId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            if (user == null) {
                throw new UserNotFoundException();
            } else if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                UserSavedMealPlans userSavedMealPlanToEdit = userSavedMealPlansRepository.findByUserAndMealPlan_mealPlanId(user, mealPlanId);
                return this.userOwnershipService.editUserSavedMealPlan(userId, mealPlanId, userSavedMealPlanToEdit.getUserSavedMealPlansId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/mealplan/all/{userId}")
    public List<UserSavedMealPlans> displayMyMealPlans(@PathVariable ("userId") Long userId) {
        try {
            User user = userRepository.findByUserId(userId);
            if (user == null){
                throw new UserNotFoundException();
            } else {
                return this.userOwnershipService.displayUserSavedMealPlans(userId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/mealplan/get/{userId}/{mealPlanId}")
    public UserSavedMealPlans getUserSavedMealPlan(@PathVariable ("userId") Long userId,
                                                    @PathVariable ("mealPlanId") Long mealPlanId) {
        try {
            User user = userRepository.findByUserId(userId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            if (user == null){
                throw new UserSavedMealPlanNotFoundException();
            } else if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                UserSavedMealPlans userSavedMealPlan = userSavedMealPlansRepository.findByUserAndMealPlan_mealPlanId(user, mealPlanId);
                return this.userOwnershipService.getUserSavedMealPlan(userSavedMealPlan.getUserSavedMealPlansId());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}