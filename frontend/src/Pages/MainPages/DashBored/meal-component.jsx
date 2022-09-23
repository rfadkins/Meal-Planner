import React, { useState } from "react"
import { Link, Routes, Route } from 'react-router-dom';

import RecipeCard from '../../../Components/Calander.Component/RecipeCard/RecipeCard.jsx'

export default function MealComponent(props) {
    const meals = props.meals
    console.log(meals)

    return (
        meals.map((meal, index) =>
            <div key={index} className="meal-component">
                <h2>{meal.name}</h2>
                <RecipeCard recipeList={meal.recipes} viewOnly={true} />
            </div>
        )
    )
}
/*
Upgrades
<button>Made</button>
<button>Skip</button>
*/