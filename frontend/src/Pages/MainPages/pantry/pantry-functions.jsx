import React from "react";
import { useNavigate } from "react-router-dom";
/*api*/
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";

/* File contains functional code for pantry */

export function getAllPantryIngredients(userId){
  //ALPHABETIZE LIST
  const testIngredients = [
    {id: 1, name: "egg", count: 3},
    {id: 2, name: "bread", count: 1},
    {id: 3, name: "milk", count: 2},
    {id: 4, name: "cheddar cheese", count: 1}
]

//const data = { username: username, password: password };
//const userPantryIngredients = await axios.get(`${baseUrl}/pantry/user/${currentUserId}`, data);

return testIngredients;
};

export async function getAllIngredients(token){
    const api = `${baseUrl}/ingredients/`
    const data = { headers: {"Authorization" : `Bearer ${token}`} }

    try {
        const ingredients = await axios.get(api, data);
        console.log(ingredients);
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

const addNewIngredient = async (e) => {
    e.preventDefault();

    //have a drop down that is based of what is being typed, if there are no ingredients found, add new
}

export const getIngredient = async (e) => {

}
