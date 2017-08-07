package com.ikisoft.pizzagame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.ikisoft.pizzagame.Input.ScaleTouch;
import com.ikisoft.pizzagame.Input.GameInput;
import com.ikisoft.pizzagame.PizzaGame;
import com.ikisoft.pizzagame.visualobjects.Belt;
import com.ikisoft.pizzagame.helpers.AssetLoader;
import com.ikisoft.pizzagame.update.GameUpdater;

/**
 * Created by Max on 4.8.2017.
 */

public class GameScreen implements Screen {


    private final com.ikisoft.pizzagame.PizzaGame game;
    private GameUpdater gameUpdater;
    private Belt belt1, belt2;
    private float runTime = 0;
    private float screenWidth;
    private float screenHeight;
    private Vector2 touchPosition;

    public GameScreen(final PizzaGame pizzaGame) {


        this.game = pizzaGame;
        gameUpdater = new GameUpdater();

        game.batch.setProjectionMatrix(game.camera.combined);
        //camera.position.set(0);

        System.out.println(game.camera.viewportWidth);
        System.out.println(game.camera.viewportHeight);
        game.camera.update();

        screenWidth = game.camera.viewportWidth;
        screenHeight = game.camera.viewportHeight;

        belt1 = new Belt(screenWidth - 32, screenHeight / 2);
        belt2 = new Belt(screenWidth, screenHeight / 2);

        Gdx.input.setInputProcessor((new GameInput(gameUpdater)));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        runTime += delta;
        touchPosition = ScaleTouch.scale(new Vector2(Gdx.input.getX(), Gdx.input.getY()));

        //tick
        gameUpdater.update();

        game.camera.update();
        //;
        Gdx.gl.glClearColor(0.82f, 0.92f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();


        //floor
        for (int i = 0; i < screenWidth; i += 32) {
            for (int j = 0; j < screenHeight; j += 32) {
                game.batch.draw(AssetLoader.textures.get(14), i, j);

            }

        }

        //chef icon
        game.batch.draw(AssetLoader.textures.get(3), screenWidth - 33, screenHeight - 33);
        //speechbubble
        game.batch.draw(AssetLoader.textures.get(33), screenWidth - 64, screenHeight - 33 - 2);
        game.batch.draw(AssetLoader.textures.get(32),
                screenWidth - 96, screenHeight - 33 - 2);
        game.batch.draw(AssetLoader.textures.get(32), screenWidth - 96, screenHeight - 33 - 2);

        //ovens
        game.batch.draw(AssetLoader.textures.get(42), screenWidth - 48 + 1, screenHeight / 2 - 16);
        game.batch.draw(AssetLoader.textures.get(41),
                screenWidth - 32, screenHeight / 2 - 32);
        game.batch.draw(AssetLoader.textures.get(40),
                screenWidth - 32, screenHeight / 2);
        //belt
        //game.batch.draw(AssetLoader.textures.get(42), screenWidth - 32, screenHeight / 2 - 16);
        game.batch.draw(AssetLoader.beltAnimation.getKeyFrame(runTime),
                screenWidth - 48,
                screenHeight / 2 - 16);

        game.batch.draw(AssetLoader.textures.get(43), 16 - 1, screenHeight / 2 - 16);
        game.batch.draw(AssetLoader.textures.get(48), 0, screenHeight / 2);
        game.batch.draw(AssetLoader.textures.get(49), 0, screenHeight / 2 - 32);
        //belt
        //game.batch.draw(AssetLoader.textures.get(42), screenWidth - 32, screenHeight / 2 - 16);
        game.batch.draw(AssetLoader.beltAnimation.getKeyFrame(runTime),
                16,
                screenHeight / 2 - 16);

        //postit
        //game.batch.draw(AssetLoader.textures.get(8), 2, screenHeight - 35);

        //pause icon
        game.batch.draw(AssetLoader.textures.get(56), 2, screenHeight - 35);
        //table
        game.batch.draw(AssetLoader.textures.get(10), screenWidth / 2 - 32, screenHeight / 2 + 3);
        game.batch.draw(AssetLoader.textures.get(11), screenWidth / 2, screenHeight / 2 + 3);
        game.batch.draw(AssetLoader.textures.get(12), screenWidth / 2 - 32, screenHeight / 2 - 32 + 3);
        game.batch.draw(AssetLoader.textures.get(13), screenWidth / 2, screenHeight / 2 - 32 + 3);
        //pizza dough
        game.batch.draw(AssetLoader.textures.get(0),
                gameUpdater.getPizzaDough().getBounds().x,
                gameUpdater.getPizzaDough().getBounds().y);
        //ingredients
        game.batch.draw(AssetLoader.textures.get(16),
                gameUpdater.getIngredient(0).getBounds().x,
                gameUpdater.getIngredient(0).getBounds().y);
        game.batch.draw(AssetLoader.textures.get(17),
                gameUpdater.getIngredient(1).getBounds().x,
                gameUpdater.getIngredient(1).getBounds().y);
        game.batch.draw(AssetLoader.textures.get(18),
                gameUpdater.getIngredient(2).getBounds().x,
                gameUpdater.getIngredient(2).getBounds().y);
        game.batch.draw(AssetLoader.textures.get(19),
                gameUpdater.getIngredient(3).getBounds().x,
                gameUpdater.getIngredient(3).getBounds().y);
        game.batch.draw(AssetLoader.textures.get(20),
                gameUpdater.getIngredient(4).getBounds().x,
                gameUpdater.getIngredient(4).getBounds().y);

        if (gameUpdater.getIngredient(0).isToggled()) {
            game.batch.draw(AssetLoader.textures.get(24),
                    touchPosition.x - 16, touchPosition.y + 16);

        }

        if (gameUpdater.getIngredient(1).isToggled()) {
            game.batch.draw(AssetLoader.textures.get(25),
                    touchPosition.x - 16, touchPosition.y + 16);

        }

        if (gameUpdater.getIngredient(2).isToggled()) {
            game.batch.draw(AssetLoader.textures.get(26),
                    touchPosition.x - 16, touchPosition.y + 16);

        }

        if (gameUpdater.getIngredient(3).isToggled()) {
            game.batch.draw(AssetLoader.textures.get(27),
                    touchPosition.x - 16, touchPosition.y + 16);

        }
        if (gameUpdater.getIngredient(4).isToggled()) {
            game.batch.draw(AssetLoader.textures.get(28),
                    touchPosition.x - 16, touchPosition.y + 16);

        }


        drawToppings();

        game.batch.end();
    }

    public void drawToppings(){

        if(gameUpdater.getToppings().get(0).isToggled()){
            game.batch.draw(AssetLoader.textures.get(24),
                    screenWidth / 2 - 16, screenHeight / 2 - 16);
        }
    }

    @Override
    public void resize(int width, int height) {
/*        game.camera.viewportWidth = 1080f;
        game.camera.viewportHeight = 1920f;
        game.camera.update();*/

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
