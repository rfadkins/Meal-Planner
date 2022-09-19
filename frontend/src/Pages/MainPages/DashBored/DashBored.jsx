import React, {useState} from "react"
import { Link, Routes, Route } from 'react-router-dom';
import './DashBored.css'
import RecipeCard from '../../../Components/Calander.Component/RecipeCard/RecipeCard.jsx'
//C:\Users\Charles\Desktop\MA_CODE_FOLDER\capstones\final-capstone\frontend\src\Components\Calander.Component\RecipeCard\RecipeCard.jsx

/*redux*/
import { useSelector } from 'react-redux';


import { getCurrentMealPlan } from "./dashboard-functions";
import MealComponent from "./meal-component";

export default function Dashbored(){
    const currentUserId = useSelector((state) => state.user.id)
    const currentUserToken = useSelector((state) => state.token.token)
    const [currentMealPlan, setCurrentMealPlan] = useState(getCurrentMealPlan(currentUserId)[0])
    //find way to only display 4 at a time
    const [mealPreview, setMealPreview] = useState(getCurrentMealPlan(currentUserId)[0].meals)

    //console.log(`currentMealPlan: ${JSON.stringify(currentMealPlan)}`)
    //console.log(`mealPreview: ${JSON.stringify(mealPreview)}`)
    return(
        <div className="dashboard">
            <h2>Current Meal Plan: {currentMealPlan.name}</h2>
            <button>Change Current Meal Plan</button>
            <MealComponent meals = {mealPreview} />
        </div>
    )
}