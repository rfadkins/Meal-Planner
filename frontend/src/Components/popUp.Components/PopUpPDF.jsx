import React from "react";
import "./PopUp.css";
import { printIngredients } from "../../Pages/MainPages/pantry/pantry-functions";

export default function PopUpPDF(props) {
  return props.trigger ? (
    <div className="popup">
      <div className="popup-inner">
        printIngredients(props.userId, props.token);

        {/* <iframe
          src="http://localhost:8081/ingredients/print"
          style="width:600px; height:500px;"
          frameborder="0"
        ></iframe> */}
        <button className="close-btn" onClick={() => props.setTrigger(false)}>
          X
        </button>
        {props.children}
      </div>
    </div>
  ) : (
    ""
  );
}
