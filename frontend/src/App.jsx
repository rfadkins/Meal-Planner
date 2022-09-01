import React from "react"
import OpeningPage from "../src/Pages/OpeningPage/OpeningPage"
import BrandImg from '../src/Images/placeHolder.png';
import LoginPage from '../src/Pages/LoginPage/LoginPage';
import SignUpPage from '../src/Pages/Sign-UpPage/Sign-UpPage'
import WelcomePage from '../src/Pages/WelcomePage/WelcomePage'

export default function App() {
  return (
    <div className="app">
      {/* <h1>App Component</h1> */}
      {/* <OpeningPage PlaceHolderImg= {BrandImg}/> */}
      {/* <LoginPage PlaceHolderImg= {BrandImg}/> */}
      {/* <SignUpPage /> */}
      <WelcomePage PlaceHolderImg= {BrandImg}/>
    </div>
  )
}
