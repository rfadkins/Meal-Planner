import React from "react"
import { Link, Routes, Route } from 'react-router-dom';

/* access pages */
import Register_Page from './Register_Page/Register_Page';
import Login_Page from './Login_Page/Login_Page';
import SignUp_Page from './Sign-Up_Page/Sign-Up_Page';
import User_Welcome_Page from './User_Welcome_Page/User_Welcome_Page';
/* access pages */

export default function Register_Routrs() {
  
    return (
    <div className="app">
      <Routes>
        {/* access pages */}
        {/* still required - help page, forgot password */}
        <Route path="/" element={<Register_Page />}/>
        <Route path="/login" element={<Login_Page />}/>
        <Route path="/sign-up" element={<SignUp_Page />}/>
        <Route path="/user-welcome" element={<User_Welcome_Page />}/>
         {/* access pages */}
      </Routes>
    </div>
  )
}
