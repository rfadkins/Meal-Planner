import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import ListItem from "../../../Components/Button.Components/ButtonListItem/ListItem";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";

import './shopping-List.css'

export default function ShoppingList(){
    return(
        <div>
            <div>
                <Bar/>
            </div>
            <br/>
            <div className="shopping-List">
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
            </div>
        </div>
    )
}