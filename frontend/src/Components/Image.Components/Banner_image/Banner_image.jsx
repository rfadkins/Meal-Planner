import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import "./Banner_image.css"
import banner from "../../../Images/banner_image.jpg"

export default function BannerImage(){
    return(
        <div>
            <img src={banner} alt="Banner-Image" className="Banner-Image"/>
        </div>
    )
}