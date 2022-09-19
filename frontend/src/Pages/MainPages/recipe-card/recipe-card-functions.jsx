import React from "react";
import axios from "axios";

/* File contains functional code for recipe-card */


export function getAllUserRecipes(userId){
    //ALPHABETIZE LIST
    const testRecipes = [
      {id: 1, name: "Baked Potato", ingredients: [{count: 1, measurement: "whole", name: "potato"}, {count: 2, measurement: "tbs", name: "butter"}, {count: 1, measurement: "pinch", name: "salt"}], instructions: "Wrap potato in foil. Bake on cooking sheet at 350 for 10 minutes. Let cool. Serve with butter and salt."},
      {id: 2, name: "Baked Potato", ingredients: [{count: 1, measurement: "whole", name: "potato"}, {count: 2, measurement: "tbs", name: "butter"}, {count: 1, measurement: "pinch", name: "salt"}], instructions: "Wrap potato in foil. Bake on cooking sheet at 350 for 10 minutes. Let cool. Serve with butter and salt."}
  ]
  
  //const data = { username: username, password: password };
  //const userPantryIngredients = await axios.get(`${baseUrl}/pantry/user/${currentUserId}`, data);
  
  return testRecipes;
  };

const getRecipesByCategory = async (e) => {
    e.preventDefault();
}

const getRecipesByName = async (e) => {
    e.preventDefault();
}

const getUserRecipe = async (e) => {
    e.preventDefault();
}

const editUserRecipe = async (e) => {
    e.preventDefault();
  };

const deleteUserRecipe = async (e) => {
    e.preventDefault();
}

const addNewRecipe = async (e) => {
    e.preventDefault();
}
