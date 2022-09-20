import React, { useState } from "react"
import { Link, Routes, Route } from 'react-router-dom';

import AddItemButtom from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";
import ButtonSelectItem from "../../../Components/Button.Components/ButtonSelectItem/ButtonSelectItem";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import './pantry.css'

import { getAllPantryIngredients, getAllIngredients, addNewIngredient, testIngredientList } from "./pantry-functions";

/*redux*/
import { useSelector } from 'react-redux';
import { useEffect } from "react";

export default function Pantry() {
    const currentUserId = useSelector((state) => state.user.id)
    const currentUserToken = useSelector((state) => state.token.token)
    const [userPantry, setUserPantry] = useState(null);
    //const [userPantry, setUserPantry] = useState(testIngredientList);
    
    //add new ingredients
    const [newIngredientName, setNewIngredientName] = useState("")
    const [newIngredientCategory, setNewIngredientCategory] = useState("")
    const [newIngredient, setNewIngredient] = useState(false)

    useEffect(() => {
        getAllPantryIngredients(currentUserId, currentUserToken)
        .then(function(result){setUserPantry(result)})
    }, [])

    function addIngredientOnClick() {
        //format and POST new ingredient
        const ingredient = { ingredientName: newIngredientName, ingredientCategory: newIngredientCategory }
        addNewIngredient(currentUserId, currentUserToken, ingredient)
        //reset input values
        setNewIngredientName("")
        setNewIngredientCategory("")
        //refresh pantry

        //setNewIngredient(newIngredient ? false : true)
        //console.log(newIngredient)
    }

    return (
        <div>
            <Bar />
            <div className="Pantry-body">

                <AddItemButtom buttonImage='+' nameHandle="Pantry-add">
                    <h3 className="title">Add ingredient</h3>
                    <p>Ingredient Name <input type="text" className="textInputLong" value={newIngredientName} onChange={() => setNewIngredientName(event.target.value)} /></p>
                    <p>Category <input type="text" className="textInputLong" value={newIngredientCategory} onChange={() => setNewIngredientCategory(event.target.value)} /></p>
                    <button className="submitButton" onClick={addIngredientOnClick}>submit</button>
                </AddItemButtom>

                <ButtonSelectItem items={userPantry} />

            </div>
        </div>
    )
}

//upgrades
//pull existing categories as options in the dropdown
//have categories be created and maintained in a settings menu