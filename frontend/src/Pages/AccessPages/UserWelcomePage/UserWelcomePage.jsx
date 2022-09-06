import React from 'react'
import ReactDOM from 'react-dom/client'
import { Link, Routes, Route } from 'react-router-dom';
import './UserWelcomePage.css'
/*components*/
import ProfileImgLarge from '../../../Components/Image.Components/Profile-Image-large/Profile-Image-Large'
import ButtonStyleOne from '../../../Components/Button.Components/ButtonStyleOne/ButtonStyleOne'
/*components*/
export default function LoginPage(props) {
    return (
      <div className='user-Welcome-Page'>
        <br/>
        <br/>
        <br/>
        <ProfileImgLarge imageSorce='../src/Images/placeHolder.png'/>
        {/* <img src='../src/Images/placeHolder.png' alt='placeHolder' className='Brand-Img'/> */}
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <img src=' ' alt='placeHolder' className='Brand-Border'/>
        <br/>
        <br/>
        <Link to="/user">
          <ButtonStyleOne buttonName="Lets get cooking!"/>
        </Link>
      </div>
    )
  }