import React from "react"
import { Link, Routes, Route } from 'react-router-dom';

import AddItemButtom from "../../../Components/Button.Components/ButtonAddItem/ButtonAddItem";
import ButtonSelectItem from "../../../Components/Button.Components/ButtonSelectItem/ButtonSelectItem";
import Bar from "../../../Components/Input.Component/search_bar/search_bar";
import './pantry.css'

export default function Pantry(){
    return(
        <div>

            <Bar/>
        
        <div className="Pantry-body">
            
            <AddItemButtom buttonImage='+'/>
            
            <ButtonSelectItem/>
            
        </div>
        </div>
    )
}