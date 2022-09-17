import "./Login_Page.css";
import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import { useNavigate } from "react-router-dom";
/*redux*/
import { useDispatch } from "react-redux";
import { addUser } from "../../../Redux/userSlice";
import { addToken } from "../../../Redux/tokenSlice";
/*api*/
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";
/*components*/
import Button_Style_One from '../../../Components/Button.Components/Button_Style_One/Button_Style_One'
import Help_Button from "../../../Components/Button.Components/Help_Button_One/Help_Button_One";
import Forgot_Button from "../../../Components/Button.Components/Help_Button_Two/Help_Button_Two";
import Brand_Image from "../../../Components/Image.Components/Brand_image/Brand_Image";
import Text_Input_One from "../../../Components/Input.Component/Text_Input_One/Text_Input_One";

export default function LoginPage(props) {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = { username: username, password: password };
    const userWithToken = await axios.post(baseUrl + "/login", data);

    dispatch(addToken(userWithToken.data.token));
    dispatch(addUser(userWithToken.data.user));

    navigate("/user-welcome");
    
  };

  return (
    <div className="login-page">
      
      <div className="Login_Banner">
        <h1 className="login-header">Welcome Back {username}!</h1>
      </div>

      <div className="Login_Icon">
        <Brand_Image />
      </div>
      
      <div className="Login_inputs">
        <Text_Input_One lableClassName="Username-label" name="Username"
          id="username" type="text" inputClassName=""
          placeholder="Username"
          onChange={(value) => setUsername(value)}
          required/>
          <br/>
        <Text_Input_One lableClassName="Password-label" name="Password" 
          id="password" type="password" inputClassName=""
          placeholder="Password" 
          onChange={(value) => setPassword(value)}
          required/>
      </div>
      <br/>
      <div className="Login_Buttons">
        <Button_Style_One buttonName="Login" onClickHandler={handleSubmit}/>
        <br/>
        <Forgot_Button buttonName="Forgot Password" />
      </div>
      <div className="Login_Help">
        <Help_Button buttonName="Help?" />
      </div>
    </div>
  );
}
