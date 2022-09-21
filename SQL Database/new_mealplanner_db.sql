rollback;
BEGIN TRANSACTION;

/* Little Bobby Tables */
DROP TABLE IF EXISTS users, meal_plan, meal, meal_recipe, recipe, recipe_ingredient, ingredient, user_pantry, user_recipe, user_meal, user_meal_plan, meal_plan_meal;
DROP SEQUENCE IF EXISTS mp_user_id, mp_meal_plan_id, mp_meal_id, mp_recipe_id, mp_ingredient_id;

/*----------------------------------------
Users Table
user_id                 PK
username                User's name
password                User's PW
-----------------------------------------*/

CREATE SEQUENCE mp_user_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE users (
    user_id int NOT NULL DEFAULT nextval('mp_user_id'),
    username varchar(50) NOT NULL,
    password varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY (user_id)
);

/*----------------------------------------
meal_plan table
meal_plan_id            PK
user_id                 FK to users table
-----------------------------------------*/

CREATE SEQUENCE mp_meal_plan_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE meal_plan (
    meal_plan_id int NOT NULL DEFAULT nextval('mp_meal_plan_id'),
    meal_plan_name varchar(50) NOT NULL,
    CONSTRAINT PK_meal_plan PRIMARY KEY (meal_plan_id)
);


/*----------------------------------------
meal table
meal_id                 PK
recipe_id               FK to recipe table
-----------------------------------------*/

CREATE SEQUENCE mp_meal_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE meal (
    meal_id int NOT NULL DEFAULT nextval('mp_meal_id'),
    meal_name varchar(50) NOT NULL ,
    CONSTRAINT PK_meal PRIMARY KEY (meal_id)
    /*CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),*/
);

/*----------------------------------------
recipe table
reciple_id              PK
recipe_name             Recipe's name
recipe_instructions     Recipe's Instructions
category                Recipe's Category
-----------------------------------------*/

CREATE SEQUENCE mp_recipe_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE recipe (
    recipe_id int NOT NULL DEFAULT nextval('mp_recipe_id'),
    recipe_name varchar(50) NOT NULL,
    recipe_instructions varchar(5000) NOT NULL,
    category varchar(50) NOT NULL,
    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
);

/*This is here because I couldn't set a foreign key in meal for recipe before recipe exists!*/
/*ALTER TABLE meal
     ADD CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id);*/

/*----------------------------------------
ingredient table
ingredient_id           PK
ingredient_name         Ingredient's name
category                Ingredient's category
count_measurement       Ingredient's count measurement
volume_measurement      Ingredient's volume measurement
-----------------------------------------*/

CREATE SEQUENCE mp_ingredient_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE ingredient (
    ingredient_id int NOT NULL DEFAULT nextval('mp_ingredient_id'),
    ingredient_name varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    count_measure varchar(50),
    unit_measure varchar(50),
    CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);





/* DEMO USERS
IDs 1 - 3 */
INSERT INTO users (username, password, role)
VALUES ('George', 'password', 'user'), ('Lizzie','password', 'user'), ('Ralph', 'password', 'user');

/*Demo Ingredients
ID 1-6 */
INSERT INTO ingredient (ingredient_name, category)
VALUES ('Milk', 'Dairy'),('Cheese','Dairy'),('Hot Pockets', 'Frozen'),('Instant Ramen', 'Salt'),('Macaroni', 'Pasta'),('Love','Care');

/*Demo Recipes
DO NOT TRY THIS AT HOME*/
INSERT INTO recipe (recipe_name, category, recipe_instructions)
VALUES ('Macaroni and Cheese Dinner', 'Pasta', 'Boil two cups of water. Add Pasta. When Pasta is cooked to desired firmness, drain pasta and mix in one cup of milk and one cup of cheese'),
('Hot Pockets du Jour', 'frozen', 'Microwave one hot pocket for 2 minutes, or two for 3:30.'),
('Ramen Noodles', 'salt', 'Boil two cups of water, add ramen to the water, stir for three minutes, remove from heat and add flavor packet'),
('Glass of Milk', 'Dairy', 'Pour 8oz of cold milk into a glass.'),
('Cheese Cubes', 'Dairy', 'Cut cheese into small cubes' );

/* meals */
INSERT INTO meal (meal_name)
VALUES ('Family Dinner'), ('Quick Lunch'), ('Healthy Breakfast'), ('Family Lunch');

/* mealplans */
INSERT INTO meal (meal_name)
VALUES ('Weeknight Dinners'), ('Camping Meals'), ('Meals for lifting'), ('Date Weekend Meals');

COMMIT;