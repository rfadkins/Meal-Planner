import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import RecipeCardPart from "../../../Components/Calander.Component/RecipeCard/RecipeCard";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import AddItemButtom from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";
import { useState } from "react";
import { getAllUserRecipes, testRecipes } from "./recipe-card-functions";
/*redux*/
import { useSelector } from 'react-redux';

export default function RecipeCard(){
    const currentUserId = useSelector((state) => state.user.id)
    const currentUserToken = useSelector((state) => state.token.token)
    const [recipeList, setRecipeList] = useState(testRecipes())

    return(
        <div>
            <div>
                <Bar/>
                <br/>
                <br/>
                <AddItemButtom buttonImage='Add Recipe' nameHandle="Recipe-add">
                <h3 className="title">New Recipe</h3>
                <p>Recipe -  <input type="text" className="textInputLong"/></p>
                <p>Ingredient - <input type="text" className="textInputLong"/></p>
                <div className="countAndDate">
                <button className="addIngredientButton">+</button>
                </div>
                <button className="submitButton">submit</button>
            </AddItemButtom>
            </div>
            <br/>
            <div className="card-List">
                <RecipeCardPart recipeList = {recipeList}/>
            </div>
        </div>
    )
}