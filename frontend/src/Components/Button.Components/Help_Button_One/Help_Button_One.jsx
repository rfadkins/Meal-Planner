import React from 'react'
import ReactDOM from 'react-dom/client'
import './Help_Button_One.css'

export default function Help_Button_One(props){
    return(
        <div>
            <button className='Help-Button'>{props.buttonName}</button>
        </div>
    )
}
