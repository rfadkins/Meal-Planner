import React from "react";
import axios from "axios";

/* File contains functional code for recipe-card */


export function getAllUserRecipes(userId) {
    

    //const data = { username: username, password: password };
    //const userPantryIngredients = await axios.get(`${baseUrl}/pantry/user/${currentUserId}`, data);

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

export function testRecipes() {
    const testRecipes = [
        { id: 1, name: "Baked Potato", ingredients: [{ id: 1, ingredientCount: 1, ingredientLabel: "whole", ingredientName: "potato" }, { id: 2, ingredientCount: 2, ingredientLabel: "tbs", ingredientName: "butter" }, { id: 3, ingredientCount: 1, ingredientLabel: "pinch", ingredientName: "salt" }], instructions: "Wrap potato in foil. Bake on cooking sheet at 350 for 10 minutes. Let cool. Serve with butter and salt." }
    ]
    return testRecipes;
};
