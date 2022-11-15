import { createSlice } from "@reduxjs/toolkit";

const dashboardSlice = createSlice({
  name: "dashboard",
  initialState: {
    currentMealPlan: { mealPlanId: null, mealPlanName: "" },
    currentMeals: [{ mealId: null, mealName: "", recipes:[{recipeName: "", ingredients:[], recipeInstructions:""}]}],
  },
  reducers: {
    addCurrentMealPlan: (state, action) => {
      state.currentMealPlan = action.payload.currentMealPlan;
    },
    addCurrentMeals: (state, action) => {
        state.currentMeals = action.payload.currentMealPlan;
    }
  },
});

export const { addCurrentMealPlan, addCurrentMeals } = dashboardSlice.actions;
export default dashboardSlice.reducer;