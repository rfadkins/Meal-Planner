import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import ListItem from "../../../Components/Button.Components/ButtonListItem/ListItem";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import AddItemButtom from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";

import './shopping-List.css'

export default function ShoppingList(){
    return(
        <div>
            <div>
                <Bar/>
            </div>
            <br/>
            <div className="shopping-List">
                
                <AddItemButtom buttonImage='+'/>
                
                <ListItem/>
                <ListItem/>
                <ListItem/>
            </div>
        </div>
    )
}