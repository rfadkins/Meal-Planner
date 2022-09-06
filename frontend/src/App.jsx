import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
/* access pages */
import AccessPages from './Pages/AccessPages/AccessPage'
/* access pages */

import MainPages from './Pages/MainPages/MainPage'

export default function App() {
  return (
    <div className="app">
      <AccessPages/>
      <MainPages/>
    </div>
  )
}
