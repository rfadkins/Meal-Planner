import React from 'react'
import ReactDOM from 'react-dom/client'
import './ButtonSelectItem.css'
import Ingrediant_Image from '../../../Images/ingredient_image_2.png'

export default function ButtonSelectItem(props) {
    const items = props.items;

    return (
        items.map((item, index) =>
            <div key={index} className='Pantry-item-body'>
                <p className="d">{item.name.substring(0,1).toUpperCase() + item.name.substring(1)}</p>
                <button className="Pantry-item-button">
                    <img src={Ingrediant_Image} alt='ingrediant image'
                        className='ingrediant_img' />
                    <p className='Item-Count'>{item.count}</p>
                </button>
            </div>
        )
    )
}
