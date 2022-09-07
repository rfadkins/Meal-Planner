import React, {useState} from "react";
import ReactDOM from "react-dom/client";
import { Link, useNavigate } from "react-router-dom";
import "./LoginPage.css";
import { useDispatch } from "react-redux";
import { userActions } from "../../../Redux/userSlice";
import { tokenActions } from "../../../Redux/tokenSlice";
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";

/*components*/
import ButtonStyleOne from "../../../Components/Button.Components/ButtonStyleOne/ButtonStyleOne";
import HelpButton from "../../../Components/Button.Components/HelpButtonOne/HelpButtonOne";
import ForgotButton from "../../../Components/Button.Components/HelpButtonTwo/HelpButtonTwo";
import TextInputOne from "../../../Components/Input.Component/TextInputOne/TextInputOne";
import BrandImg from "../../../Components/Image.Components/Brand-image/Brand-Image";

/*components*/
export default function LoginPage(props) {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = { username: username, password: password };
    const userWithToken = await axios.post(baseUrl + "/login", data);

    console.log(JSON.stringify(userWithToken))

    //await dispatch(addToken(userWithToken.data.token))
    dispatch(userActions.addUser(userWithToken.data.user));
    
    navigate("/user-welcome");
  };

  return (
    <div className="login-Page">
      <h1 className="login-Header">welcome to the app</h1>
      <br />
      <BrandImg />
      <br />

      <label className="SignUp-Page--label">Username</label>
      <input
        type="text"
        id="username"
        name="username"
        className="SignUp-Page--input"
        placeholder="Username"
        onChange={(event) => setUsername(event.target.value)}
        required
      />
      <label className="SignUp-Page--label">Password</label>
      <input
        type="password"
        id="password"
        name="password"
        className="SignUp-Page--input"
        placeholder="Password"
        onChange={(event) => setPassword(event.target.value)}
        required
      />

      <br />
      
      <button onClick={handleSubmit}>Login</button>

      <br />
      <ForgotButton buttonName="Forgot Password" />
      <br />
      <HelpButton buttonName="Help?" />
    </div>
  );
}
