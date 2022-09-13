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
                <button className="Pantry-add"
                    onClick={() => setButtonPopup(true)}
                >{props.buttonImage}</button>
            </main>
            <PopUp trigger={buttonPopup} setTrigger={setButtonPopup}>
                {/*item name*/} <input type="text"/>
                {/*item catagory*/} <input type="text"/>
                {/*item count*/} <input type="text"/>
                {/*date added*/} <input type="text"/>
                <button>submit</button>
            </PopUp>
        </div>
    )
}