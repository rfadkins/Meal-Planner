BEGIN TRANSACTION;

/* Little Bobby Tables */
DROP TABLE IF EXISTS users, meal_plan, meal, meal_recipe, recipe, recipe_ingredient, ingredient, ingredient_pantry, pantry;


/*---------------------------------------- 
Users Table
user_id                 PK
username                User's name
password                User's PW
-----------------------------------------*/

CREATE TABLE users (
    user_id int NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(200) NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY (user_id)
);

/*---------------------------------------- 
meal_plan table
meal_plan_id            PK
user_id                 FK to users table         
-----------------------------------------*/

CREATE TABLE meal_plan (
    meal_plan_id int NOT NULL,
    user_id int NOT NULL, 
    CONSTRAINT PK_meal_plan PRIMARY KEY (meal_plan_id),
    CONSTRAINT FK_meal_plan_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);


/*---------------------------------------- 
meal table
meal_id                 PK
recipe_id               FK to recipe table
meal_plan_id            FK to meal_plan table
-----------------------------------------*/

CREATE TABLE meal (
    meal_id int NOT NULL,
    recipe_id int NOT NULL,
    meal_plan_id int NOT NULL,
    CONSTRAINT PK_meal PRIMARY KEY (meal_id),
    /*CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),*/
    CONSTRAINT FK_meal_meal_plan_id FOREIGN KEY (meal_plan_id) REFERENCES meal_plan (meal_plan_id) 
);

/*---------------------------------------- 
recipe table
reciple_id              PK
recipe_name             Recipe's name
recipe_instructions     Recipe's Instructions
category                Recipe's Category
meal_id                 FK to meal table
-----------------------------------------*/

CREATE TABLE recipe (
    recipe_id int NOT NULL,
    recipe_name varchar(50) NOT NULL,
    recipe_instructions varchar(5000) NOT NULL,
    category varchar(50) NOT NULL,
    meal_id int NOT NULL,
    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id),
    CONSTRAINT FK_recipe_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

/*This is here because I couldn't set a foreign key in meal for recipe before recipe exists!*/
ALTER TABLE meal 
     ADD CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id);

/*---------------------------------------- 
ingredient table
ingredient_id           PK
ingredient_name         Ingredient's name
category                Ingredient's category
-----------------------------------------*/

CREATE TABLE ingredient (
    ingredient_id int NOT NULL,
    ingredient_name varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);

/*---------------------------------------- 
Pantry table
pantry_id               PK 
user_id                 FK to users table
-----------------------------------------*/

CREATE TABLE pantry (
    pantry_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_pantry PRIMARY KEY (pantry_id),
    CONSTRAINT FK_pantry_users FOREIGN KEY (user_id) REFERENCES users (user_id) 
);

/*---------------------------------------- 
meal_recipe table  (JOIN TABLE)
recipe_id               FK to recipe table
meal_id                 FK to meal table
-----------------------------------------*/

CREATE TABLE meal_recipe (
    recipe_id int NOT NULL,
    meal_id int NOT NULL,
    CONSTRAINT FK_meal_recipe_reipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),
    CONSTRAINT FK_meal_recipe_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

/*---------------------------------------- 
recipe_ingredient table (JOIN TABLE)
ingredient_id           FK to ingredient table
recipe_id               FK to recipe table
-----------------------------------------*/

CREATE TABLE recipe_ingredient (
    ingredient_id int NOT NULL,
    recipe_id int NOT NULL,
    CONSTRAINT FK_recipe_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id),
    CONSTRAINT FK_recipe_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

/*---------------------------------------- 
ingredient_pantry table  (JOIN TABLE)
pantry_id               FK to pantry table
ingredient_id           FK to ingredient table
-----------------------------------------*/

CREATE TABLE ingredient_pantry (
    pantry_id int NOT NULL,
    ingredient_id int NOT NULL,
    CONSTRAINT FK_ingredient_pantry_pantry FOREIGN KEY (pantry_id) REFERENCES pantry (pantry_id),
    CONSTRAINT FK_ingredient_pantry_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id) 
);

COMMIT;