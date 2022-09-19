import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import './Dashbored.css'
import RecipeCard from '../../../Components/Calander.Component/RecipeCard/RecipeCard.jsx'
//C:\Users\Charles\Desktop\MA_CODE_FOLDER\capstones\final-capstone\frontend\src\Components\Calander.Component\RecipeCard\RecipeCard.jsx

export default function Dashbored(){
    return(
        <div>
            <header className="mostRecent">
                {/* most recent recipes */}
                <h4>Last viewed recipes-</h4>
            </header>
            {/*  */}
            <div className="Recipe_stack">
                {/*recipe cards here*/}
            </div>
        </div>
    )
}