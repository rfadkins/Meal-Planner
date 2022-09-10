import './User_Welcome_Page.css'
import React from 'react'
import ReactDOM from 'react-dom/client'
import { Link, Routes, Route } from 'react-router-dom';
/*redux*/
import { useSelector } from 'react-redux';
/*components*/
import Profile_Img_Large from '../../../Components/Image.Components/Profile-Image-large/Profile-Image-Large'
import Button_Style_One from '../../../Components/Button.Components/Button_Style_One/Button_Style_One'
import Banner_Image from "../../../Components/Image.Components/Banner_image/Banner_image";
import Profile_Img from '../../../Images/profile.png'
export default function UserWelcomePage() {

  const currentUser = useSelector((state)=>state.user.username)
  const formattedCurrentUser = currentUser.substring(0,1).toUpperCase() + currentUser.substring(1)

    return (
      <div className='user-Welcome-Page'>
        <br/>
        <br/>
        <h1>Welcome, {formattedCurrentUser}!</h1>
        <br/>
        <Profile_Img_Large imageSorce={Profile_Img}/>
        {/* <img src='../src/Images/placeHolder.png' alt='placeHolder' className='Brand-Img'/> */}
        <br/>
        <Banner_Image />
        <Link to="/user">
          <Button_Style_One buttonName="Lets get cooking!"/>
        </Link>
      </div>
    )
  }