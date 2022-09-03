import React from 'react'
import ReactDOM from 'react-dom/client'
import './UserWelcomePage.css'
/*components*/
import ProfileImg from '../../../Components/Image.Components/Profile-Image/Profile-Image'
/*components*/
export default function LoginPage(props) {
    return (
      <div className='user-Welcome-Page'>
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