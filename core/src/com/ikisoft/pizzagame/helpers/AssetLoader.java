package com.ikisoft.pizzagame.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by Max on 4.8.2017.
 */

public class AssetLoader {

    public static Texture texture;
    private static int textureIndex = 0;
    public static ArrayList<TextureRegion> textures;
    public static Animation<TextureRegion>beltAnimation;

    public static void load(){

        texture = new Texture(Gdx.files.internal("texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapLinearLinear);

        textures = new ArrayList<TextureRegion>();


        //go trough a 256x256 textureatlas and index every 16x16 block by rows
        for(int i = 0; i < texture.getHeight(); i += 32){
            for(int j = 0; j < texture.getWidth(); j += 32){

                textures.add(textureIndex, new TextureRegion(texture, j, i, 32, 32));
                textureIndex++;
            }
        }

        TextureRegion[] belt = {textures.get(45), textures.get(46)};
        beltAnimation = new Animation<TextureRegion>(0.3f, belt);
        beltAnimation.setPlayMode(Animation.PlayMode.LOOP);


    }
}