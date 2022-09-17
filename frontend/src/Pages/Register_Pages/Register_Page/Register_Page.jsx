import React from 'react'
import ReactDOM from 'react-dom/client'
import './Register_Page.css'
import { Link } from 'react-router-dom'

/*components*/ 
import Button_Style_One from '../../../Components/Button.Components/Button_Style_One/Button_Style_One'
import Brand_Image from '../../../Components/Image.Components/Brand_image/Brand_Image'
import Text_Banner from '../../../Components/Banner.Component/Text_Banner/Text_Banner'
import Help_Button from '../../../Components/Button.Components/Help_Button_One/Help_Button_One'
import Register_Banner from '../../../Components/Banner.Component/Register_Banner/Register_Banner'
/*components*/

export default function OpeningPage() {
    return (
      <div className='Register_Page'>
        <div className='Register_page_Banner'>
        <Register_Banner />
        </div>

        <div className='Register_page_Icon'>
          <Brand_Image/>
        </div>

        <div className='Register_page_Welcome_Banner'>
          <Text_Banner text='This is where the description will got for the welcome page.'/>
        </div>

        <div className='Register_page_Buttons'>
          <Link to="/login">
            <Button_Style_One buttonName="Login"/>
          </Link>
          <br/>
          <Link to="/sign-up">
            <Button_Style_One buttonName="Sign-Up"/>
          </Link>
          <br/>
          <Help_Button buttonName="Help?"/>
        </div>
      </div>
    )
  }