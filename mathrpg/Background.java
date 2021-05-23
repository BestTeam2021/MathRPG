package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;



public class Background  {
    private static Background object;
    private Texture backgroundTexture;
    Image backgroundImage;



    private Background() {
        backgroundTexture = new Texture("brick_wall.png");
        backgroundTexture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion =  new TextureRegion(backgroundTexture);
        textureRegion.setRegion(0,0,backgroundTexture.getWidth()*8,backgroundTexture.getHeight()*4);
        backgroundImage =  new Image(textureRegion);
        backgroundImage.setSize(200,100);
        backgroundImage.setPosition(Gdx.graphics.getWidth()*2/3-backgroundImage.getWidth()/2,Gdx.graphics.getHeight()/3-backgroundImage.getHeight());

    }



    public static Background getObject() {
        if (object == null) {
            object = new Background();
        }
        return object;
    }

    public Image getBackground() {
        return backgroundImage;
    }
}



