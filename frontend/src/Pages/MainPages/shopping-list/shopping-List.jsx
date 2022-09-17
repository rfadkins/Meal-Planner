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
                <br/>
                <br/>
                <AddItemButtom buttonImage='+' nameHandle="Shopping-add">
                    <h3 className="title">Add to Shopping List</h3>
                    <p>Item name? <input type="text" className="textInputLong"/></p>
                    <p>Catagory? <input type="text" className="textInputLong"/></p>
                    <div className="countAndDate">
                        <p className="E">How many? <input type="text" className="textInputShort"/></p>
                        
                        <p>Date added? <input type="text" className="textInputShort"/></p>
                    </div>
                    <button className="submitButton">submit</button>
                </AddItemButtom>
            </div>
            <br/>
            <div className="shopping-List">
                
                
                
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                <ListItem/>
                
            </div>
        </div>
    )
}