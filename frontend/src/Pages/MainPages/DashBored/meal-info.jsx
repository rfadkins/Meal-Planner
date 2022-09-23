import React, { useState } from "react"
import "./DashBored.css"
import RecipeInformation from "./recipe-info";

export default function MealInformation(props) {
    const arr = props.meals;
    const setArr = props.setMeals;

    const addInput = () => {
        setArr(s => {
            return [
                ...s,
                {
                    name: "",
                    recipes: []
                }
            ];
        });
    };

    

    const handleChangeName = e => {
        e.preventDefault();

        const index = e.target.id;
        setArr(s => {
            const newArr = s.slice();
            newArr[index].name = e.target.value;
            return newArr;
        });
    };

    const handleChangeRecipe = e => {
        e.preventDefault();

        const index = e.target.id;
        setArr(s => {
            const newArr = s.slice();
            newArr[index].recipes.push(e.target.value);
            return newArr;
        });
    };

    //dropdown

    return (
        <div>

            {arr.map((item, i) => {
                const [recipes, setRecipes] = useState(item.recipes)
                return (
                    <div key={i} id={i} className="meal-info">
                        <input
                            id={i}
                            onChange={handleChangeName}
                            value={item.name}
                            type="text"
                            className="meal-info-name"
                            placeholder="Meal Name"
                        />
                        <RecipeInformation recipes={recipes} setRecipes={setRecipes} />
                        
                    </div>
                );
            })}
            <div className="popup-buttons">
                            <button className="addIngredientButton" onClick={addInput}>Add Meal</button>
                        </div>
            

        </div>
    );

}