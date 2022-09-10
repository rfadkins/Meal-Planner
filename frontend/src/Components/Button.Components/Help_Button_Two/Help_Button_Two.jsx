import React from 'react'
import ReactDOM from 'react-dom/client'
import './Help_Button_Two.css'

export default function ButtonStyle1(props){
    return(
        <div>
            <button className='login-forgot-password'>{props.buttonName}</button>
        </div>
    )
}
