import React from 'react'
import ReactDOM from 'react-dom/client'
import { Link } from 'react-router-dom'

export default function LoginPage(props) {
    return (
      <div className='login-Page'>
        <h1 className='login-Header'>welcome to the app</h1>
        <br/>
        <img src='../src/Images/placeHolder.png' alt='placeHolder' className='Brand-Img'/>
        <br/>
        <br/>
        <br/>
        <input className='login-input' placeholder='login'/>
        <br/>
        <input className='login-input' placeholder='password'/>
        <br/>
          <Link to="/user-welcome">
            <button className='login-Button'>Login</button>
          </Link>
        <br/>
        <p className='login-forgot-password'>Forgot Password</p>
        <p className='login-Help'>Help?</p>
      </div>
    )
  }