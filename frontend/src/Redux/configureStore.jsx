import { configureStore, applyMiddleware } from "@reduxjs/toolkit";
import userSlice from "./userSlice";
import tokenSlice from "./tokenSlice";
import thunk from "redux-thunk";

const store = configureStore({
    reducer:{
        user: userSlice.reducer,
        token: tokenSlice.reducer
    }
})

export default store