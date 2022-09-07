import {createSlice} from "@reduxjs/toolkit"

const userSlice = createSlice({
    name: 'user',
    initialState: {
        id: null,
        username: '',
        authorities: []
    },
    reducers:{

        addUser(state, action){
            return { ...state, id: action.payload.id, username: action.payload.username, authorities: action.payload.authorities }
        },
        deleteUser(state){
            return { ...state, id: null, username: '', authorities: [] }
        }
    }
})

export const userActions = userSlice.actions;
export default userSlice