import React from 'react'
import ReactDOM from 'react-dom/client'
import { useState } from 'react'
import PopUp from '../../popUp.Components/PopUp'
import './ButtonAddItem.css'

export default function AddItemButtom(props){

    const [buttonPopup, setButtonPopup] = useState(false)

    return(
        <div>
            <main>
                <button className={props.nameHandle}
                    onClick={() => setButtonPopup(true)}
                >{props.buttonImage}</button>
            </main>
            <PopUp trigger={buttonPopup} setTrigger={setButtonPopup}>
                {props.children}
            </PopUp>
        </div>
    )
}