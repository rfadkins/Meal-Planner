import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import RecipeCardPart from "../../../Components/Calander.Component/RecipeCard/RecipeCard";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import AddItemButtom from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";

export default function RecipeCard(){
    return(
        <div>
            <div>
                <Bar/>
            </div>
            <br/>
            <div className="card-List">
                <AddItemButtom buttonImage='+'/>
                <RecipeCardPart/>
                <RecipeCardPart/>
                <RecipeCardPart/>
            </div>
        </div>
    )
}