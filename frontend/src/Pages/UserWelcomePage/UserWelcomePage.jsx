import React from 'react'
import ReactDOM from 'react-dom/client'
import './UserWelcomePage.css'
import ProfileImg from '../../Components/Image.Components/Profile-Image/Profile-Image'

export default function LoginPage(props) {
    return (
      <div className='login-Page'>
        <br/>
        <br/>
        <br/>
        <ProfileImg imageSorce='../src/Images/placeHolder.png'/>
        {/* <img src='../src/Images/placeHolder.png' alt='placeHolder' className='Brand-Img'/> */}
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <img src=' ' alt='placeHolder' className='Brand-Border'/>
      </div>
    )
  }