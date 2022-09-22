import React from 'react'
import { useState } from 'react'
/* Components */
import PopUp from '../../popUp.Components/PopUp'
import './ButtonAddItem.css'

export default function AddItemButton(props){
    const setMain = props.setMain
    const [buttonPopup, setButtonPopup] = useState(false)

    return(
        <div className="add-item-button">
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