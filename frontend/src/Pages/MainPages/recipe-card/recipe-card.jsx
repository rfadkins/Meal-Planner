import React, { useState } from "react"
import "./recipe-card.css"
/* components */
import RecipeCardPart from "../../../Components/Calander.Component/RecipeCard/RecipeCard";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import AddItemButton from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";
import IngredientInformation from "./ingredient-info";
/* js functionality */
import { getAllUserRecipes, testRecipes } from "./recipe-card-functions";
/* redux */
import { useSelector } from 'react-redux';

export default function RecipeCard() {
    const currentUserId = useSelector((state) => state.user.id)
    const currentUserToken = useSelector((state) => state.token.token)
    const [recipeList, setRecipeList] = useState(testRecipes())

    //new recipe
    const [newRecipeName, setNewRecipeName] = useState("")
    const [newRecipeIngredients, setNewRecipeIngredients] = useState(
        [{
            id: 1,
            ingredientName: "",
            ingredientCount: "",
            ingredientLabel: ""
        }]
    )
    const [newRecipeInstructions, setNewRecipeInstructions] = useState("")

    return (
        <div className="recipe-card">
            <Bar />
            <AddItemButton buttonImage='Add Recipe' nameHandle="Recipe-add">
                <h3 className="title">New Recipe</h3>
                <p>Recipe Name <input type="text" className="textInputLong" /></p>
                <IngredientInformation 
                    ingredients = {newRecipeIngredients} 
                    setIngredients = {setNewRecipeIngredients} />
                <p>Instructions</p>
                <input type="text" className="textInputBox" />
                <div className="popup-buttons">
                    <button className="submitButton">Submit</button>
                </div>
            </AddItemButton>
            <div className="card-List">
                <RecipeCardPart recipeList={recipeList} />
            </div>
        </div>
    )
}