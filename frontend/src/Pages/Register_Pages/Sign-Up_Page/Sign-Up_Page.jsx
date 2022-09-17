import "./Sign-Up_Page.css";
import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import { useNavigate } from "react-router-dom";
/*api*/
import axios from "axios";
import { baseUrl } from "../../../api/baseUrl";
/*components*/
import Help_Button from "../../../Components/Button.Components/Help_Button_One/Help_Button_One";
import Text_Banner from "../../../Components/Banner.Component/Text_Banner/Text_Banner";
import Text_Input_One from "../../../Components/Input.Component/Text_Input_One/Text_Input_One";
import Button_Style_One from '../../../Components/Button.Components/Button_Style_One/Button_Style_One'
import Banner_Image from "../../../Components/Image.Components/Banner_image/Banner_image";

export default function SignUpPage(props) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      username: username,
      password: password,
      confirmPassword: confirmPassword,
      role: "USER",
    };

    try {
      if (password === confirmPassword) {
        const response = await axios.post(baseUrl + "/register", data);
        alert("Registration Successful");
        console.log(response);
        navigate("/login");
      } else {
        alert("Password and Confirm Password must match!");
      }
    } catch (err) {
      if (!err?.response) {
        alert("No Server Response");
      } else if (err.response?.status === 409) {
        alert("Username Taken");
      } else {
        alert("Registration Failed");
      }
    }
  };

  return (
    <div className="SignUp-Page">
      
      <div className="sign_up_banner">
        <Banner_Image />
      </div>

      <div className="sign_up_welcome">
        <Text_Banner text={`welcome _${username}_! lets get cooking`} />
      </div>
      
      <div className="sign_up_inputs-buttons">
        <Text_Input_One lableClassName="Username-label" name="Username"
            id="username" type="text" inputClassName=""
              placeholder="Username"
              onChange={(value) => setUsername(value)}
              required/>

        <Text_Input_One lableClassName="Password-label" name="Password" 
            id="password" type="password" inputClassName=""
          placeholder="Password" 
          onChange={(value) => setPassword(value)}
              required/>

        <Text_Input_One lableClassName="Password-label" name="confirmPassword" 
            id="password-confirm" type="password" inputClassName=""
          placeholder="Confirm Password" 
          onChange={(value) => setConfirmPassword(value)}
              required/>

        {/* <label className="SignUp-label">Username</label>
        <input
          type="text"
          id="username"
          name="username"
          className="SignUp-input"
          placeholder="Username"
          onChange={(event) => setUsername(event.target.value)}
          required
        />
        <label className="SignUp-label">Password</label>
        <input
          type="password"
          id="password"
          name="password"
          className="SignUp-input"
          placeholder="Password"
          onChange={(event) => setPassword(event.target.value)}
          required
        />
        <input
          type="password"
          id="password-confirm"
          name="confirmPassword"
          className="SignUp-input"
          placeholder="Confirm Password"
          onChange={(event) => setConfirmPassword(event.target.value)}
          required
        /> */}

        <br/>
        <Button_Style_One buttonName="Sign-up" onClickHandler={handleSubmit}/>
        {/* <button className="SignUp-button" onClick={handleSubmit}>
          Sign-up
        </button> */}

        <br />
        <Help_Button buttonName="Help?" />
      </div>
    </div>
  );
}

/*
  Removed for now

  <TextInputOne textPlaceHolder='email'/>
  <br/>
  <TextInputOne textPlaceHolder='dietary goals'/>
  <br/>
  <TextInputOne textPlaceHolder='dietary restrictions'/>
  <br/>
  */
