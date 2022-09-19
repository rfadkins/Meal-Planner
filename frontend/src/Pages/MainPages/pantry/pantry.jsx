import React, {useState} from "react"
import { Link, Routes, Route } from 'react-router-dom';

import AddItemButtom from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";
import ButtonSelectItem from "../../../Components/Button.Components/ButtonSelectItem/ButtonSelectItem";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import './pantry.css'

import { getAllPantryIngredients, getAllIngredients } from "./pantry-functions";

/*redux*/
import { useSelector } from 'react-redux';

export default function Pantry(){
    const currentUserId = useSelector((state) => state.user.id)
    const currentUserToken = useSelector((state) => state.token.token)
    const [userPantry, setUserPantry] = useState(getAllPantryIngredients(currentUserId));

    const allIngredients = getAllIngredients(currentUserToken)

    //add new ingredients
    const [newIngredientName, setNewIngredientName] = useState("")
    const [newIngredientCategory, setNewIngredientCategory] = useState("")
    const [newIngredientCount, setNewIngredientCount] = useState("")


    return(
        <div>
            <Bar/>
        <div className="Pantry-body">
            
            <AddItemButtom buttonImage='+' nameHandle="Pantry-add">
                <h3 className="title">Add ingredient</h3>
                <p>Item name? <input type="text" className="textInputLong"/></p>
                <p>Catagory? <input type="text" className="textInputLong"/></p>
                <div className="countAndDate">
                    <p className="E">How many? <input type="text" className="textInputShort"/></p>
                </div>
                <button className="submitButton">submit</button>
            </AddItemButtom>
            
            <ButtonSelectItem items={userPantry}/>
            
        </div>
        </div>
    )
}