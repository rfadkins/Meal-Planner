import React from 'react'
import ReactDOM from 'react-dom/client'
import './ButtonAddItem.css'

export default function AddItemButtom(props){
    return(
        <div>
            <button className="Pantry-add">{props.buttonImage}</button>
        </div>
    )
}
