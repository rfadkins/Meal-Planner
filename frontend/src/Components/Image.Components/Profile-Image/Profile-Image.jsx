import React from "react";
import './Profile-Image.css'

export default function ProfileImage(props){
    return(
        <div>
            <img src={props.imageSorce} alt='Profile-Image' className='Profile-Img'/>
        </div>
        
    )
}