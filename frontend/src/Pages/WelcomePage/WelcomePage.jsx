import React from 'react'
import ReactDOM from 'react-dom/client'
import './WelcomePage.css'
import { Link } from 'react-router-dom'
import ButtonStyleOne from '../../Components/Button.Components/ButtonStyleOne'
import BrandImg from '../../Components/Image.Components/Brand-image/Brand-Image'
// frontend\src\Components\Image.Components\Brand-image\Brand-Image.jsx
export default function OpeningPage() {
    return (
      <div className='welcome-Page'>
        <h1 className='welcomeHeader'>welcome to the app</h1>
        <br/>
        <BrandImg sorce='../src/Images/placeHolder.png'/>
        
        <p className='welcome-Descritpuon'>This where the description will got for the welcome page.</p>
        <br/>
        <Link to="/login">
          <ButtonStyleOne buttonName="Login"/>
        </Link>
        <br/>
        <Link to="/sign-up">
          <ButtonStyleOne buttonName="Sign-Up"/>
        </Link>
        <br/>
        <br/>
        <br/>
        <p className='welcome-Help'>Help?</p> 

      </div>
    )
  }