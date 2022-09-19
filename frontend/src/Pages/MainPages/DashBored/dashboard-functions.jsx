import React from "react";
import { useNavigate } from "react-router-dom";
/*api*/
import { baseUrl } from "../../../api/baseUrl";
import axios from "axios";

/* File contains functional code for pantry */

export function getCurrentMealPlan(userId) {
    //ALPHABETIZE LIST
    const testMealPlans = [
        {
            id: 1, name: "Meal Plan 1", meals: [
                {
                    name: "meal a", recipes: [
                        { id: 1, name: "Omelet", ingredients: [{ count: 2, measurement: "large", name: "egg" }, { count: 2, measurement: "tbs", name: "butter" }, { count: .25, measurement: "cup", name: "cheese" }], instructions: "Omelet instructions" },
                        { id: 2, name: "Breakfast Potatoes", ingredients: [{ count: 1, measurement: "whole", name: "potato" }, { count: 2, measurement: "tbs", name: "butter" }, { count: 1, measurement: "pinch", name: "salt" }], instructions: "Breakfast potatoes instructions" }
                    ]
                },
                {
                    name: "meal b", recipes: [
                        { id: 1, name: "Baked Potato", ingredients: [{ count: 1, measurement: "whole", name: "potato" }, { count: 2, measurement: "tbs", name: "butter" }, { count: 1, measurement: "pinch", name: "salt" }], instructions: "Wrap potato in foil. Bake on cooking sheet at 350 for 10 minutes. Let cool. Serve with butter and salt." }
                    ]
                },
                {
                    name: "meal c", recipes: [
                        { id: 1, name: "Baked Potato", ingredients: [{ count: 1, measurement: "whole", name: "potato" }, { count: 2, measurement: "tbs", name: "butter" }, { count: 1, measurement: "pinch", name: "salt" }], instructions: "Wrap potato in foil. Bake on cooking sheet at 350 for 10 minutes. Let cool. Serve with butter and salt." },
                        { id: 2, name: "Steak", ingredients: [{ count: 6, measurement: "oz", name: "Steak" }, { count: 2, measurement: "tbs", name: "butter" }, { count: 1, measurement: "pinch", name: "salt" }], instructions: "Steak instructions" },
                        { id: 3, name: "Mac and Cheese", ingredients: [{ count: 1, measurement: "pound", name: "Elbow Pasta" }, { count: 2, measurement: "tbs", name: "butter" }, { count: 1, measurement: "cup", name: "cheese" }], instructions: "Mac and Cheese instructions" }
                    ]
                }
            ]
        }
    ]

    //const data = { username: username, password: password };
    //const userPantryIngredients = await axios.get(`${baseUrl}/pantry/user/${currentUserId}`, data);

    return testMealPlans;
};