import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import './NavigationBar.css'

// import Dashbored from '../../Pages/MainPages/DahsBored/DahsBored.jsx'
import Profile_Img_Small from '../Image.Components/Profile-Image-Small/Profile-Image-Small'
import Icon_Button from '../Image.Components/IconButton/IconButton'

// images
import Profile_Img from '../../Images/profile.png'
import Search_Img from '../../Images/profile.png'
import Pantry_Img from '../../Images/ingredient_image_3.png'
import Recipe_Img from '../../Images/meal_image_2.png'
import Shopping_Img from '../../Images/grocery_image_2.png'

export default function NavigationBar(props){
    return(
        <div className="Navbar-body">
            <header className="Navbar-header">
                <Profile_Img_Small imageSorce={Profile_Img}/>
            </header>
            <section className="Navbar-right">
                {/* search bar */}<Icon_Button imageSorce={Search_Img} linkHandler="/user-dash"/>
                {/* pantry gallary */}<Icon_Button imageSorce={Pantry_Img} linkHandler="/user-pantry"/>                
                {/* recipe gallary */}<Icon_Button imageSorce={Recipe_Img} linkHandler="/user-recipe-card"/>
                {/* shopping list */}<Icon_Button imageSorce={Shopping_Img} linkHandler="/user-shopping-list"/>
                {/* ? */}{/*<Icon_Button imageSorce={Search_Img}/>*/}
                {/* ? */}{/*<Icon_Button imageSorce={Search_Img}/>*/}
            </section>
            <section className="Main-content">
                <div>
                    {props.mainContent}
                </div>
            </section>
            <section className="Navbar-left">
                {/* settings */}{/*<Icon_Button imageSorce={Search_Img}/>*/}
                {/* logout */}{/*<Icon_Button imageSorce={Search_Img}/>*/}
                {/* ? */}{/*<Icon_Button imageSorce={Search_Img}/>*/}
            </section>
            <footer className="Navbar-footer">Random Recipe</footer>
        </div>
    )
}