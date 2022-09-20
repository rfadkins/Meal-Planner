import React from "react"
import './RecipeCard.css'

export default function RecipeCardPart(props) {
    const recipeList = props.recipeList
    
    return (
        recipeList.map((recipe, index) =>
            <div key={index} className="RecipeCard">
                <p className="RecipeCard-text">
                    {recipe.name}
                </p>
                <p className="RecipeCard-text">
                    Ingredients:
                    {recipe.ingredients.map((ingredient, index) =>
                        <li key={index}>{ingredient.count} {ingredient.measurement} {ingredient.name}</li>
                    )}
                </p>
                <p className="RecipeCard-text">
                    Instructions:<br></br>
                    {recipe.instructions}
                </p>
            </div>
        )
    )
}