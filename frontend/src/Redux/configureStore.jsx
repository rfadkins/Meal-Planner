import { configureStore, applyMiddleware } from "@reduxjs/toolkit";
import userReducer from "./userSlice";
import tokenReducer from "./tokenSlice";
import dashboardReducer from "./dashboardSlice"
import thunk from "redux-thunk";

const store = configureStore({
  reducer: {
    user: userReducer,
    token: tokenReducer,
    dashboard: dashboardReducer
  },
});

export default store;
