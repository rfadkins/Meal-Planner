import React from 'react'
import ReactDOM from 'react-dom/client'
import './ButtonSelectItem.css'
import Ingrediant_Image from '../../../Images/ingredient_image_2.png'

export default function ButtonSelectItem(props){
    return(
        <div className='Pantry-item-body'>
            <p className="d">item name</p>
            <button className="Pantry-item-button">
                
                <img src={Ingrediant_Image} alt='ingrediant image'
                    className='ingrediant_img'/>
                
                <p className='Item-Count'>00</p>
            </button>
            
        </div>
    )
}
