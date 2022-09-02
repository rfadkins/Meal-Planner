import React from "react"
import { Link, Routes, Route } from 'react-router-dom';

/* pages */
import WelcomePage from './Pages/WelcomePage/WelcomePage';
import LoginPage from './Pages/LoginPage/LoginPage';
import SignUpPage from './Pages/Sign-UpPage/Sign-UpPage';
import UserWelcomePage from './Pages/UserWelcomePage/UserWelcomePage';
/* pages */

export default function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/" element={<WelcomePage />}/>
        <Route path="/login" element={<LoginPage />}/>
        <Route path="/sign-up" element={<SignUpPage />}/>
        <Route path="/user-welcome" element={<UserWelcomePage />}/>
      </Routes>
    </div>
  )
}
