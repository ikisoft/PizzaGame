package com.ikisoft.pizzagame.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Max on 5.8.2017.
 */

public class GameObject {

    protected Vector2 position;
    protected Rectangle bounds;
    protected boolean isToggled;

    public GameObject(float x, float y, float width, float height) {

        position = new Vector2(x, y);
        bounds = new Rectangle(x, y, width, height);
        isToggled = false;
    }

    public GameObject(float x, float y) {

        position = new Vector2(x, y);
        isToggled = false;
    }


    protected Rectangle getBounds() {

        return bounds;
    }

    public Vector2 getPosition(){
        return position;
    }

    public boolean isTouched(Vector2 position) {

        /*System.out.println("BOUND X: " + bounds.x);
        System.out.println("BOUND Y: " + bounds.y);*/

        if (position.x >= bounds.x  && position.x <= bounds.x + bounds.width) {

            if (position.y >= bounds.y && position.y <= bounds.y + bounds.height) {

                System.out.println("asdasd");
                return true;

            }
        }
        return false;
    }

    public void setToggled(boolean toggled){
        isToggled = toggled;
    }

    public boolean isToggled(){
        return isToggled;
    }
}
