//package com.techelevator.datatransfer;
//import java.io.File;
//import java.io.IOException;
//
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//public class JSONParser {
//
//    JSONParser parser = new JSONParser();
//    ObjectMapper mapper = new ObjectMapper();
//
//    public void readRecipe() {
//        try {
//            RecipeDTO recipe = mapper.readValue(new File("recipe.json"), RecipeDTO.class);
//        } catch (Exception e) {
//
//        }
//    }
//
//
//    try {
//        // read JSON from a file
//
//        MealDTO meal = parser.readValue(new File("meal.json"), MealDTO.class);
//        IngredientDTO ingredient = parser.readValue(new File("ingredient.json"), IngredientDTO.class);
//        MealPlanDTO mealPlan = parser.readValue(new File("mealPlan.json"), MealPlanDTO.class);
//
//        // write JSON to a file
//        parser.writeValue(new File("recipe.json"), recipe);
//        parser.writeValue(new File("meal.json"), meal);
//        parser.writeValue(new File("ingredient.json"), ingredient);
//        parser.writeValue(new File("mealPlan.json"), mealPlan);
//
//    } catch (JsonParseException e) {
//        e.printStackTrace();
//    } catch (JsonMappingException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//
//}
