import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import RecipeCard from '../../../Components/Calander.Component/RecipeCard/RecipeCard.jsx'
//C:\Users\Charles\Desktop\MA_CODE_FOLDER\capstones\final-capstone\frontend\src\Components\Calander.Component\RecipeCard\RecipeCard.jsx

export default function Dashbored(){
    return(
        <div>
            {/* <h1>dashbored</h1> */}
            <RecipeCard/>
            <RecipeCard/>
            <RecipeCard/>
        </div>
    )
}