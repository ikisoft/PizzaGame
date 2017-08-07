package com.ikisoft.pizzagame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Max on 6.8.2017.
 */

public class ScaleTouch {

    public static Vector2 scale(Vector2 position) {

        position.x = (position.x / Gdx.graphics.getWidth()) * 256;
        position.y = 138 - (position.y / Gdx.graphics.getHeight()) * 138;

        return position;

    }
}
