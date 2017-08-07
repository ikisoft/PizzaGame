package com.ikisoft.pizzagame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ikisoft.pizzagame.helpers.AssetLoader;
import com.ikisoft.pizzagame.helpers.Constants;
import com.ikisoft.pizzagame.screens.GameScreen;

public class PizzaGame extends Game {

	public SpriteBatch batch;
	public Camera camera;
	public float runTime = 0;


	@Override
	public void create () {

		AssetLoader.load();
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIRTUAL_WIDTH, Constants.VIRTUAL_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();
		this.setScreen(new GameScreen(this));
		//renderer = new GameScreen();
		//camera.zoom = 0.5f;
	}

	@Override
	public void render () {
		runTime += Gdx.graphics.getDeltaTime();
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
