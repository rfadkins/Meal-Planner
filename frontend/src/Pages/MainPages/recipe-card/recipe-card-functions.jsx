/* api */
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";
/* outside javascript functions needed */
import { addNewIngredient } from "../pantry/pantry-functions";

/* File contains functional code for recipe-card */


export async function getAllUserRecipes(userId, token) {
    try {
        const authHeader = { headers: { "Authorization": `Bearer ${token}` } }
        const userRecipes = await axios.get(`${baseUrl}/user/recipe/all/${userId}`, authHeader)
        console.log(userRecipes)
        return userRecipes.data
    } catch (err) {
        alert("Recipes not found");
        const returnValue = []
        return returnValue
    }
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

export async function addNewRecipe(userId, token, recipe) {
    try {
        const authHeader = { headers: { "Authorization": `Bearer ${token}` } }

        const recipeFormattedForTable = { recipeName: recipe.recipeName, category: recipe.category, recipeInstructions: recipe.recipeInstructions }
        let ingredientFormattedForJoin = []

        //add recipe to table, will need id from response
        const addRecipeTable = `${baseUrl}/recipe/`
        const addRecipeTableResponse = await axios.post(addRecipeTable, recipeFormattedForTable, authHeader)
        const recipeId = addRecipeTableResponse.data.recipeId
        console.log("Added recipe to table")
        //add each ingredient, add response (data.ingredientId) to array
        recipe.ingredients.map((ingredient) => {
            addNewIngredient(userId, token, ingredient)
                .then(function (result) {
                    console.log(`response for adding ingredient ${result}`)
                    ingredientFormattedForJoin.push(
                        {
                            ingredientId: result.ingredientId,
                            ingredientQuantity: ingredient.ingredientCount,
                            ingredientMeasurement: ingredient.ingredientLabel
                        }
                    )
                })
        })
        console.log("Ingredients added to table")
        //join ingredients to recipe
        ingredientFormattedForJoin.map((ingredient) => {
            joinIngredientToRecipe(token, recipeId, ingredientForJoin)
        })
        console.log("Ingredients joined to recipe")
        //join recipes to user
        const joinRecipeToUserTable = `${baseUrl}/user/recipe/add/${userId}/${recipeId}`
        const joinRecipeToUserTableResponse = await axios.post(joinRecipeToUserTable, "", authHeader)
        console.log("Recipe joined to user")
    } catch (err) {
        alert(err);
    }

    //Upgrades to functionality:
    //have a drop down that is based of what is being typed, if there are no ingredients found, add new
}

export async function joinIngredientToRecipe(token, recipeId, ingredientForJoin) {
    try {

        const ingredientId = ingredientForJoin.ingredientId
        const body = {
            ingredientQuantity: ingredientForJoin.ingredientQuantity,
            ingredientMeasurement: ingredientForJoin.ingredientMeasurement
        }
        const authHeader = { headers: { "Authorization": `Bearer ${token}` } }
        const joinIngredientToRecipeTable = `${baseUrl}/ingredient/recipe/${ingredientId}/${recipeId}`
        const joinIngredientToRecipeTableResponse = await axios.post(joinIngredientToRecipeTable, body, authHeader)
    } catch (err) {
        alert("Recipes not found");
        const returnValue = []
        return returnValue
    }
};

export function testRecipes() {
    const testRecipes = [
        { id: 1, name: "Baked Potato", ingredients: [{ id: 1, ingredientCount: 1, ingredientLabel: "whole", ingredientName: "potato" }, { id: 2, ingredientCount: 2, ingredientLabel: "tbs", ingredientName: "butter" }, { id: 3, ingredientCount: 1, ingredientLabel: "pinch", ingredientName: "salt" }], instructions: "Wrap potato in foil. Bake on cooking sheet at 350 for 10 minutes. Let cool. Serve with butter and salt." }
    ]
    return testRecipes;
};
