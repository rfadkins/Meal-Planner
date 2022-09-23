import React, { useState } from "react"
import { Link, Routes, Route } from 'react-router-dom';

import RecipeCard from '../../../Components/Calander.Component/RecipeCard/RecipeCard.jsx'

/*redux*/
import { useSelector } from 'react-redux';
import { useEffect } from "react";

export default function MealComponent(props) {
    const currentUserId = useSelector((state) => state.user.id)
    const currentUserToken = useSelector((state) => state.token.token)

    const meals = useSelector((state) => state.dashboard.currentMeals)

    return (
        meals.map((meal, index) => {
            const [recipes, setRecipes] = useState(meal.recipes);
            // async function onStartup() {
            //     const retrievedRecipes = await getCurrentMealRecipes(currentUserToken, item.mealId)
            //     setRecipes(retrievedRecipes)
            //     console.log(recipes)
            // }

            // onStartup();

            <div key={index} className="meal-component">
                <h2>{meal.mealName}</h2>
                <RecipeCard recipeList={recipes} viewOnly={true} />
            </div>
        })
    )
}
/*
Upgrades
<button>Made</button>
<button>Skip</button>
*/