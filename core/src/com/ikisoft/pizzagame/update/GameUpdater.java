package com.ikisoft.pizzagame.update;

import com.ikisoft.pizzagame.gameobjects.Ingredient;
import com.ikisoft.pizzagame.gameobjects.Topping;

import java.util.ArrayList;

/**
 * Created by Max on 4.8.2017.
 */

public class GameUpdater {

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<Topping> toppings = new ArrayList<Topping>();
    private ArrayList<Topping> activeToppings = new ArrayList<Topping>();
    private Ingredient pizzaDough;

  /*  private Ingredient tomatoCan, cheeseCan, oliveCan, salamiCan, mushroomCan;
    private Topping tomato, cheese, olive, salami, mushroom;
*/

    public GameUpdater(){

        ingredients.add(0, new Ingredient(48, 3, 32, 32, "Tomato", 0));
        ingredients.add(1, new Ingredient(80, 3, 32, 32, "Cheese", 1));
        ingredients.add(2, new Ingredient(112, 3, 32, 32, "Olive", 2));
        ingredients.add(3, new Ingredient(144, 3, 32, 32, "Salami", 3));
        ingredients.add(4, new Ingredient(176, 3, 32, 32, "Mushroom", 4));

        toppings.add(0, new Topping(112, 85, "Tomato Topping,", 0));
        toppings.add(0, new Topping(112, 85, "Cheese Topping", 1));
        toppings.add(0, new Topping(112, 85, "Olive Topping", 2));
        toppings.add(0, new Topping(112, 85, "Salami Topping", 3));
        toppings.add(0, new Topping(112, 85, "Mushroom Topping", 4));

        pizzaDough = new Ingredient(256 / 2 - 16, 138 / 2 - 16, 32, 32);

        /*tomato = new Topping(112, 85);
        cheese = new Topping(112, 85);
        olive = new Topping(112, 85);
        salami = new Topping(112, 85);
        mushroom = new Topping(112, 85);*/


    }

    public void update(){


    }

    public void addTopping(int id){

        activeToppings.add(toppings.get(id));

    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void clearToppings(){

            activeToppings.clear();

    }

    public Ingredient getIngredient(int index){

        return ingredients.get(index);
    }

    public Ingredient getPizzaDough(){
        return pizzaDough;
    }
}
