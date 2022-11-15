import React from "react"
import { Link, Routes, Route } from 'react-router-dom';

import Dashbored from './DashBored/DashBored'
import Pantry from './pantry/pantry'
import Shopping_List from './shopping-list/shopping-List'
import RecipeCard from "./recipe-card/recipe-card";
import Print from "./print/print";
import NavBar from '../../Components/Navigation.Component/NavigationBar'

export default function MainPage(){
    return (
      <div>
        <Routes>
          <Route
            path="/user-dash"
            element={
              <>
                {" "}
                <NavBar mainContent={<Dashbored />} />{" "}
              </>
            }
          />
          <Route
            path="/user-pantry"
            element={
              <>
                {" "}
                <NavBar mainContent={<Pantry />} />{" "}
              </>
            }
          />
          <Route
            path="/user-shopping-list"
            element={
              <>
                {" "}
                <NavBar mainContent={<Shopping_List />} />{" "}
              </>
            }
          />
          <Route
            path="/user-recipe-card"
            element={
              <>
                {" "}
                <NavBar mainContent={<RecipeCard />} />{" "}
              </>
            }
          />
          <Route
            path="/ingredients/print"
            element={
              <>
                {" "}
                <NavBar mainContent={<Print />} />{" "}
              </>
            }
          />
        </Routes>
      </div>
    );
}