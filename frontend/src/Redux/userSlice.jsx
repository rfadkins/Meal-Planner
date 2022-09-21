import { createSlice } from "@reduxjs/toolkit";

const userSlice = createSlice({
  name: "user",
  initialState: {
    id: null,
    username: "",
    authorities: [],
  },
  reducers: {
    addUser: (state, action) => {
      state.id = action.payload.userId;
      state.username = action.payload.username;
      state.authorities = action.payload.authorities;
      //return { ...state, id: action.payload.id, username: action.payload.username, authorities: action.payload.authorities }
    },
    deleteUser: (state) => {
      return { ...state, id: null, username: "", authorities: [] };
    },
  },
});

export const { addUser, deleteUser, getUser } = userSlice.actions;
export default userSlice.reducer;
