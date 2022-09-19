import React, { useState } from "react"
import { Link, Routes, Route } from 'react-router-dom';

import RecipeCard from '../../../Components/Calander.Component/RecipeCard/RecipeCard.jsx'

/*redux*/
import { useSelector } from 'react-redux';

export default function MealComponent(props) {
    const meals = props.meals

    return (
        meals.map((meal, index) =>
            <div key={index} className="meal-component">
                <h3>{meal.name}</h3>
                {meal.recipes.map((recipe) => 
                    <li key={recipe.id}>{recipe.name}</li>
                )}
                <button>Made</button>
                <button>Skip</button>
            </div>
        )
    )
}