import React, { useState } from "react";
import "./pantry.css";
/* Components */
import ButtonPrint from "../../../Components/Button.Components/ButtonPrint/ButtonPrint";

/* Functional Javascript */
import { printIngredients } from "../pantry/pantry-functions.jsx";
/* Redux */
import { useSelector } from "react-redux";
import { useEffect } from "react";

export default function Print() {
  const currentUserId = useSelector((state) => state.user.id);
  const currentUserToken = useSelector((state) => state.token.token);
  const [userPantry, setUserPantry] = useState([]);
  //const [userPantry, setUserPantry] = useState(testIngredientList());

  //add new ingredients
  const [newIngredientName, setNewIngredientName] = useState("");
  const [newIngredientCategory, setNewIngredientCategory] = useState("");

//   useEffect(() => {
//     getAllPantryIngredients(currentUserId, currentUserToken).then(function (
//       result
//     ) {
//       setUserPantry(result);
//     });
//   }, []);

  function addIngredientOnClick() {
    //format and POST new ingredient
    const ingredient = {
      ingredientName: newIngredientName,
      ingredientCategory: newIngredientCategory,
    };
    addNewIngredient(currentUserId, currentUserToken, ingredient);
    //reset input values
    setNewIngredientName("");
    setNewIngredientCategory("");
    //refresh pantry
  }

  return (
    <div className="pantry">
      <div className="Pantry-body">
  
        <ButtonPrint
        //   items={userPantry}
          token={currentUserToken}
          userId={currentUserId}
        />
      </div>
    </div>
  );
}
