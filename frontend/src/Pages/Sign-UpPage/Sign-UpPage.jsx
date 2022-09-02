import React from 'react'
import ReactDOM from 'react-dom/client'
import './Sign-UpPage.css'
import { Link } from 'react-router-dom'
import ButtonStyleOne from '../../Components/Button.Components/ButtonStyleOne'

export default function LoginPage(props) {
    return (
      <div className='login-Page'>
        <br/>
        <img src=' ' alt='placeHolder' className='Brand-Border'/>
        <p className='welcome-Descritpuon'>Just a few questions</p>
        <br/>
        <input className='login-input' placeholder='user name'/>
        <br/>
        <input className='login-input' placeholder='password'/>
        <br/>
        <input className='login-input' placeholder='conferm password'/>
        <br/>
        <input className='login-input' placeholder='email'/>
        <br/>
        <input className='login-input' placeholder='dietary goals'/>
        <br/>
        <input className='login-input' placeholder='dietary restrictions'/>
        <br/>
        <Link to="/user-welcome">
          <ButtonStyleOne buttonName="Submit"/>
        </Link>
        <br/>
        <p className='login-Help'>Help?</p>
      </div>
    )
  }