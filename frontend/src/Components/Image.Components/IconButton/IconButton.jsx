import React from "react";
import './IconButton.css'
import { Link, Routes, Route } from 'react-router-dom';

export default function IconButton(props){
    return(
        <div className="iconDiv">
            <Link to={props.linkHandler}>
            <button className="button">
                <img src={props.imageSorce} alt='Profile-Image' 
            className='Profile-Image-Smallest'
            />
            </button>
            </Link>
        </div>
        
    )
}