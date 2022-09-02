package com.techelevator.business;

import com.techelevator.model.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    public Recipe createRecipe () {

return new Recipe();
    }


}
