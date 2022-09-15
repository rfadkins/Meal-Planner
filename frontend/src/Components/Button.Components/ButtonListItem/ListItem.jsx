import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import './ListItem.css'
import icon from'../../../Images/grocery_image_3.png'

export default function ListItem(){
    return(
        <div>
            <br/>
            <div>
                <p className="d">item name</p>
                <button className="List-item">
                    
                    <img src={icon} alt="shopping image" className="shopping_icon"/>
                    <input type="checkbox"/>
                </button>
            </div>
        </div>
    )
}