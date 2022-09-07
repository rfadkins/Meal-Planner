import {createSlice} from "@reduxjs/toolkit"

const tokenSlice = createSlice({
    name: 'token',
    initialState: {
        token: undefined
    },
    reducers:{
        addtoken(state, action){
            return { ...state, token: action.payload }
        }
    }
})

export const tokenActions = tokenSlice.actions;
export default tokenSlice