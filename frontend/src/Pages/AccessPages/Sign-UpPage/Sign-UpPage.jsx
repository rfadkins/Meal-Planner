import React from 'react'
import ReactDOM from 'react-dom/client'
import './Sign-UpPage.css'
import { Link } from 'react-router-dom'
/*components*/
import ButtonStyleOne from '../../../Components/Button.Components/ButtonStyleOne/ButtonStyleOne'
import HelpButton from '../../../Components/Button.Components/HelpButtonOne/HelpButtonOne'
import TextInputOne from '../../../Components/Input.Component/TextInputOne/TextInputOne'
import TextBanner from '../../../Components/Banner.Component/Text-Banner.Component'
/*components*/
// frontend\src\Components\Button.Components\ButtonStyleOne\ButtonStyleOne.jsx
export default function LoginPage(props) {
    return (
      <div className='SignUp-Page'>
        <br/>
        <img src=' ' alt='placeHolder' className='Brand-Border'/>
        <TextBanner text='Just a few questions'/>
        <br/>
        <TextInputOne textPlaceHolder='user name'/>
        <br/>
        <TextInputOne textPlaceHolder='password'/>
        <br/>
        <TextInputOne textPlaceHolder='conferm password'/>
        <br/>
        <TextInputOne textPlaceHolder='email'/>
        <br/>
        <TextInputOne textPlaceHolder='dietary goals'/>
        <br/>
        <TextInputOne textPlaceHolder='dietary restrictions'/>
        <br/>
        <Link to="/user-welcome">
          <ButtonStyleOne buttonName="Submit"/>
        </Link>
        <br/>
        <HelpButton buttonName="Help?"/>
      </div>
    )
  }