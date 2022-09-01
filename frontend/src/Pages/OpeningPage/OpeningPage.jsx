import React from 'react'
import ReactDOM from 'react-dom/client'

export default function OpeningPage(props) {
    return (
      <div className='welcome-Page'>
        <h1 className='welcomeHeader'>welcome to the app</h1>
        <br/>
        <img src={props.PlaceHolderImg} alt='placeHolder' className='Brand-Img'/>
        <p className='welcome-Descritpuon'>This where the description will got for the welcome page.</p>
        <br/>
        <br/>
        <br/>
        <button className='login-Button'>Login</button>
        <br/>
        <button className='signUp-Button'>Sign-Up</button>
        <br/>
        <br/>
        <br/>
        <p className='welcome-Help'>Help?</p>
      </div>
    )
  }