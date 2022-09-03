import React from 'react'
import ReactDOM from 'react-dom/client'
import { Link } from 'react-router-dom'
import './LoginPage.css'
/*components*/
import ButtonStyleOne from '../../../Components/Button.Components/ButtonStyleOne/ButtonStyleOne'
import HelpButton from '../../../Components/Button.Components/HelpButtonOne/HelpButtonOne'
import ForgotButton from '../../../Components/Button.Components/HelpButtonTwo/HelpButtonTwo'
import TextInputOne from '../../../Components/Input.Component/TextInputOne/TextInputOne'
import BrandImg from '../../../Components/Image.Components/Brand-image/Brand-Image'
/*components*/
export default function LoginPage(props) {
    return (
      <div className='login-Page'>
        <h1 className='login-Header'>welcome to the app</h1>
        <br/>
        <BrandImg />
        <br/>
        <br/>
        <br/>
        <TextInputOne textPlaceHolder='login'/>
        <br/>
        <TextInputOne textPlaceHolder='password'/>
        <br/>
        <Link to="/user-welcome">
          <ButtonStyleOne buttonName="Login"/>
        </Link>
        <br/>
        <ForgotButton buttonName="Forgot Password"/>
        <br/>
        <HelpButton buttonName="Help?"/>
      </div>
    )
  }