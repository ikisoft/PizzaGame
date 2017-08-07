package com.ikisoft.pizzagame.gameobjects;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Max on 5.8.2017.
 */

public class Ingredient extends com.ikisoft.pizzagame.gameobjects.GameObject {

    private String name;
    private int id;

    public Ingredient(float x, float y, float width, float height, String name, int id) {
        super(x, y, width, height);
        this.name = name;
        this.id = id;
        isToggled = false;
    }

    public Ingredient(float x, float y, float width, float height) {
        super(x, y, width, height);
        isToggled = false;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
