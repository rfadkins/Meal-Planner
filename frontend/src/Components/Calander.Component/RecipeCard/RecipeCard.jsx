import React from "react"
import './RecipeCard.css'

export default function RecipeCardPart(){
    return(
    <div className="RecipeCard">
        
        <p className="RecipeCard-text">
            <strong>-recipe name-</strong>
        </p>
        <p className="RecipeCard-text">
            description of dish
        </p>
        <p className="RecipeCard-text">
        ingredient - messure ~ ingredient - messure <br/>
        ingredient - messure ~ ingredient - messure<br/>
        ingredient - messure ~ ingredient - messure <br/>
        ingredient - messure ~ ingredient - messure<br/>
        </p>
    </div>
    )
}