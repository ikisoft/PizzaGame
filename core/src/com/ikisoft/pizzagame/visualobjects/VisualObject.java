package com.ikisoft.pizzagame.visualobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Max on 4.8.2017.
 */

public class VisualObject {

    protected Vector2 position;

    public VisualObject(float x, float y){
        position = new Vector2();
        position.x = x;
        position.y = y;

    }

    public void update(){

    }

    public Vector2 getPosition(){
        return position;
    }
}
