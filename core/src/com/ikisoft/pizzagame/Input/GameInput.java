package com.ikisoft.pizzagame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.ikisoft.pizzagame.helpers.Constants;
import com.ikisoft.pizzagame.update.GameUpdater;

/**
 * Created by Max on 5.8.2017.
 */

public class GameInput implements InputProcessor {

    private GameUpdater gameUpdater;
    private Vector2 position;

    public GameInput(GameUpdater gameUpdater){

        this.gameUpdater = gameUpdater;

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        position = scale(new Vector2(screenX, screenY));


        if(gameUpdater.getIngredient(0).isTouched(position)){

            System.out.println("TOMATO");
            gameUpdater.getIngredient(0).setToggled(true);
            System.out.println(gameUpdater.getIngredient(0).isToggled());


        } else if(gameUpdater.getIngredient(1).isTouched(position)){
            gameUpdater.getIngredient(1).setToggled(true);
            System.out.println("CHEESE");


        }  else if(gameUpdater.getIngredient(2).isTouched(position)){
            System.out.println("OLIVE");
            gameUpdater.getIngredient(2).setToggled(true);


        } else if(gameUpdater.getIngredient(3).isTouched(position)){
            System.out.println("PEP");
            gameUpdater.getIngredient(3).setToggled(true);

        } else if(gameUpdater.getIngredient(4).isTouched(position)){
            System.out.println("SHROOM");
            gameUpdater.getIngredient(4).setToggled(true);

        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        position = scale(new Vector2(screenX, screenY));

        for(int i = 0; i < 5; i++){
            gameUpdater.getIngredient(i).setToggled(false);

        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private Vector2 scale(Vector2 position) {

        position.x = (position.x / Gdx.graphics.getWidth()) * Constants.VIRTUAL_WIDTH;
        position.y = 138 - (position.y / Gdx.graphics.getHeight()) * Constants.VIRTUAL_HEIGHT;

        return position;

    }
}

