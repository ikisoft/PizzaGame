package com.ikisoft.pizzagame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 480 * 2;
		config.height = 270 * 2;
		new LwjglApplication(new com.ikisoft.pizzagame.PizzaGame(), config);
	}
}
