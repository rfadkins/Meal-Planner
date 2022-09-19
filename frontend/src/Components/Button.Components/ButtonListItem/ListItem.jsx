import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import './ListItem.css'
import icon from '../../../Images/grocery_image_3.png'

export default function ListItem(props) {
    const shoppingList = props.shoppingList

    return (
        shoppingList.map((item, index) =>
            <button key={index} className="List-item">
                <div className="d">
                    <p>{item}</p>
                    <input type="checkbox" />
                </div>
                <input type="text" placeholder="Note" />
            </button>
        )
    )
}