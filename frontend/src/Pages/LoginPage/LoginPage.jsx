import React from 'react'
import ReactDOM from 'react-dom/client'

export default function LoginPage(props) {
    return (
      <div className='login-Page'>
        <h1 className='login-Header'>welcome to the app</h1>
        <br/>
        <img src={props.PlaceHolderImg} alt='placeHolder' className='Brand-Img'/>
        <br/>
        <br/>
        <br/>
        <input className='login-input' placeholder='login'/>
        <br/>
        <input className='login-input' placeholder='password'/>
        <br/>
        <button className='login-Button'>Login</button>
        <br/>
        <p className='login-forgot-password'>Forgot Password</p>
        <p className='login-Help'>Help?</p>
      </div>
    )
  }