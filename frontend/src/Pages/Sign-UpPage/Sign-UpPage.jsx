import React from 'react'
import ReactDOM from 'react-dom/client'

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
        <button className='login-Button'>Submit</button>
        <br/>
        <p className='login-Help'>Help?</p>
      </div>
    )
  }