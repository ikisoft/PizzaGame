package com.ikisoft.pizzagame.gameobjects;

/**
 * Created by Max on 6.8.2017.
 */

public class Topping extends GameObject {

    private String name;
    private int id;
    private boolean isSpawned;

    public Topping(float x, float y, String name, int id) {
        super(x, y);
        this.name = name;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public boolean isSpawned(){
        return isSpawned;
    }
}
