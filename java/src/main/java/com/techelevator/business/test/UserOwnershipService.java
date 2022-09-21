//package com.techelevator.business.test;
//
//import com.techelevator.exceptions.*;
//import com.techelevator.model.*;
//import com.techelevator.repository.*;
//import com.techelevator.util.BasicLogger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class UserOwnershipService {
//    @Autowired
//    private RecipeRepository recipeRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private IngredientRepository ingredientRepository;
//    @Autowired
//    private MealRepository mealRepository;
//    @Autowired
//    private MealPlanRepository mealPlanRepository;
//
//
//
//    //TODO test
//    public Set<Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId) {
//        Set<Ingredient> pantry = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                pantry = user.getUserPantry();
//                pantry.add(ingredient);
//                user.setUserPantry(pantry);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return pantry;
//    }
//
//
//    //TODO remove ing from pan
//    public Set<Ingredient> removeIngredientFromUserPantry(Long userId, Long ingredientId) {
//        Set<Ingredient> pantry = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                pantry = user.getUserPantry();
//                pantry.remove(ingredient);
//                user.setUserPantry(pantry);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return pantry;
//    }
//
//    //todo list pantry
//    public List<Ingredient> displayUserPantry(Long userId) {
//        User user = userRepository.findByUserId(userId);
//        List<Ingredient> pantry = new ArrayList<>();
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            }
//            pantry = displayUserPantry(userId);
//        }  catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//
//        return pantry;
//    }
////    public Set<Ingredient> listUserPantry(Long userId) {
////        Set<Ingredient> pantry = new HashSet<>();
////        User user = userRepository.findByUserId(userId);
////        try {
////            if (user == null) {
////                throw new UserNotFoundException();
////            } else {
////                pantry = user.getUserPantry();
////            }
////        } catch (Exception e) {
////            BasicLogger.log(e.getMessage());
////        }
////        return pantry;
////    }
//
//    public Set<Recipe> addRecipeToUser (Long userId, Long recipeId) {
//        Set<Recipe> userRecipes = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (recipe == null) {
//                throw new RecipeNotFoundException();
//            } else {
//                userRecipes = user.getUserRecipes();
//                userRecipes.add(recipe);
//                user.setUserRecipes(userRecipes);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userRecipes;
//    }
//
//    public Set<Recipe> listUserRecipes(Long userId) {
//        Set<Recipe> userRecipes = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else {
//                userRecipes = user.getUserRecipes();
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userRecipes;
//    }
//
//    //todo add user to meal
//    public Set<Meal> addMealToUser(Long userId, Long mealId) {
//        Set<Meal> userMeals = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        Meal meal = mealRepository.findByMealId(mealId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (meal == null) {
//                throw new MealNotFoundException();
//            } else {
//                userMeals = user.getUserMeals();
//                userMeals.add(meal);
//                user.setUserMeals(userMeals);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userMeals;
//    }
//
//    //todo remove user from meal
//    public Set<Meal> removeMealFromUser(Long userId, Long mealId)  {
//        Set<Meal> userMeals = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        Meal meal = mealRepository.findByMealId(mealId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (meal == null) {
//                throw new MealNotFoundException();
//            } else {
//                userMeals = user.getUserMeals();
//                userMeals.remove(meal);
//                user.setUserMeals(userMeals);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userMeals;
//    }
//
//    //todo display users meals
//    public Set<Meal> listUserMeals(Long userId) {
//        Set<Meal> userMeals = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else {
//                userMeals = user.getUserMeals();
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userMeals;
//    }
//
//    //todo add user to meal plan
//    public Set<MealPlan> addMealPlanToUser(Long userId, Long mealPlanId) {
//        Set<MealPlan> userMealPlans = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (mealPlan == null) {
//                throw new MealPlanNotFoundException();
//            } else {
//                userMealPlans = user.getUserMealPlans();
//                userMealPlans.add(mealPlan);
//                user.setUserMealPlans(userMealPlans);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userMealPlans;
//    }
//
//    //todo remove user from meal plan
//    public Set<MealPlan> removeMealPlanFromUser(Long userId, Long mealPlanId) {
//        Set<MealPlan> userMealPlans = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else if (mealPlan == null) {
//                throw new MealPlanNotFoundException();
//            } else {
//                userMealPlans = user.getUserMealPlans();
//                userMealPlans.remove(mealPlan);
//                user.setUserMealPlans(userMealPlans);
//
//                userRepository.saveAndFlush(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userMealPlans;
//    }
//
//    //todo list/display meal plan
//
//    public Set<MealPlan> listUserMealPlans(Long userId) {
//        Set<MealPlan> userMealPlans = new HashSet<>();
//        User user = userRepository.findByUserId(userId);
//        try {
//            if (user == null) {
//                throw new UserNotFoundException();
//            } else {
//                userMealPlans = user.getUserMealPlans();
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userMealPlans;
//    }
//
//    public List<User> listAllUsers() {
//        List<User> users = new ArrayList<>();
//        try {
//            users = userRepository.findAll();
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return users;
//    }
//
//
//}
