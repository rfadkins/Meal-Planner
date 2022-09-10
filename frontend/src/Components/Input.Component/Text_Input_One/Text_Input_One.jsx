import React from "react";
import './Text_Input_One.css'

export default function Text_Input_One(props){
    const {lableClassName, name, type, id,  placeholder} = props;
    
    return(
        <div className="Input_Body">
            <label className={lableClassName}>{name}</label>
            <input
            type={type}
            id={id}
            name={name}
            className="text_input"
            placeholder={placeholder}
            onChange={(event) => props.onChange(event.target.value)}
            required
            />
        </div>
    )
}