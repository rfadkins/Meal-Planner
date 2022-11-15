import React, { useState } from "react";
import "./buttonprint.css";
/* Components */
import PDF_Image from "../../../Images/print-pdf.png";
import PopUpPDF from "../../popUp.Components/PopUpPDF";
// import {
//   printIngredients
  
// } from "../../../Pages/MainPages/pantry/pantry-functions";
export async function printIngredients(userId, token) {
  try {
    const authHeader = {
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/pdf",
      },
    };
    const printIngredients = await axios.get(
      `${baseUrl}/ingredients/print}`,
      authHeader
    );
    return printIngredients;
  } catch (err) {
    alert("Ingredients not found");
  }
}  
export default function ButtonPrint(props) {
    const ingredients = props.ingredients;
    const userId = props.userId;
    const token = props.token;


const [buttonPopup, setButtonPopup] = useState(false);
function printIngredientOnClick(currentUserId, currentToken) {
const updatedIngredient = { ingredientId: item.ingredientId, ingredientName: newIngredientName, ingredientCategory: newIngredientCategory }
printIngredients(token, userId)
setButtonPopup(false)
}

return (
    

        <div className='Pantry-item-body'>
            <button className="print-ingredients-button" onClick={() => printIngredients(token,userId)}>
                <p className="d">"Ingredients"</p>
                <img src={PDF_Image} alt='PDF image'
                    className='pdf_img' />
            </button>
             {/* <PopUpPDF trigger={buttonPopup} setTrigger={setButtonPopup}>
                printIngredientOnClick(userId, token);
                {/* printIngredients(userId, token) */}
                {/* <p>Ingredient Name <input type="text" className="textInputLong" value={newIngredientName} onChange={() => setNewIngredientName(event.target.value)} /></p>
                <p>Category <input type="text" className="textInputLong" value={newIngredientCategory} onChange={() => setNewIngredientCategory(event.target.value)} /></p>
                <div className='popup-buttons'>
                    <button className="submitButton" onClick={editIngredientOnClick}>Update</button>
                    <button className="deleteButton" onClick={deleteIngredientOnClick}>Delete</button>
                </div> */}
    {/* </PopUpPDF>   */}
        </div>
    )
}
        