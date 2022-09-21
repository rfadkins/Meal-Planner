import React from "react";
import { useNavigate } from "react-router-dom";
/*api*/
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";

/* File contains functional code for pantry */

export async function getAllPantryIngredients(userId, token) {
  //ALPHABETIZE LIST?

  const authHeader = { headers: { "Authorization": `Bearer ${token}` } }

  const userPantryIngredients = await axios.get(`${baseUrl}/pantry/user/${userId}`, authHeader)
  return userPantryIngredients.data

  
};

export async function getAllIngredients(token) {
  try {
    const api = `${baseUrl}/ingredients/`
    const authHeader = { headers: { "Authorization": `Bearer ${token}` } }
    const ingredients = await axios.get(api, authHeader);
    return ingredients.data
  } catch (err) {
    alert(err);
  }
}

const getIngredientsByCategory = async (e) => {
  e.preventDefault();
}

const getIngredientsByName = async (e) => {
  e.preventDefault();
}

const getPantryIngredient = async (e) => {
  e.preventDefault();
}

const editPantryIngredient = async (e) => {
  e.preventDefault();
};

const deletePantryIngredient = async (e) => {
  e.preventDefault();
}

export async function addNewIngredient(userId, token, ingredient) {
  try {
    const authHeader = { headers: { "Authorization": `Bearer ${token}` } }

    //add new ingredient to ingredient table
    const addIngredientTable = `${baseUrl}/ingredient/`
    //const addIngredientTable = `${baseUrl}/test/ingredient`
    const addIngredientTableResponse = await axios.post(addIngredientTable, ingredient, authHeader)
    const ingredientId = addIngredientTableResponse.data.ingredientId
    console.log(`Successfully added into Ingredient Table`)

    //using response, join new ingredient to user
    const joinIngredientToUser = `${baseUrl}/pantry/${userId}/${ingredientId}`
    const joinIngredientToUserResponse = await axios.post(joinIngredientToUser, "", authHeader)
    console.log(`Successfully joined to User Table`)
  } catch (err) {
    alert(err);
  }

  //Upgrades to functionality:
  //have a drop down that is based of what is being typed, if there are no ingredients found, add new
}

export const getIngredient = async (e) => {

}

export function testIngredientList() {
  const testIngredients = [
    { ingredientId: 1, ingredientName: "egg"},
    { ingredientId: 2, ingredientName: "bread"},
    { ingredientId: 3, ingredientName: "milk"},
    { ingredientId: 4, ingredientName: "cheddar cheese"}
  ]
  return testIngredients;
};
