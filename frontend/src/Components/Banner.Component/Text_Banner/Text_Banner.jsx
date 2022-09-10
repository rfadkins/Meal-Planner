import React from "react";
import "../../../Components/Banner.Component/Text_Banner/Text_Banner.css"

export default function Text_Banner(props){
    return(
        <div>
            <p className='text_banner'>{props.text}</p>
        </div>
    )
}