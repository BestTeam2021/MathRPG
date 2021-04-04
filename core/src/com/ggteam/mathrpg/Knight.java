package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Knight {
    public Sprite knightSprite;
    public static float xPosSprite;
    public static float yPosSprite;
    public static float speed_sprite = 0.2f;
    public Knight() {


    }

    public void render(SpriteBatch batch) {
        this.knightSprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        this.knightSprite.setPosition(x, y);
    }

    public void handleTouch(float x, float y) {
        if ((double)(x - this.knightSprite.getWidth() / 2.0F) > 0.0D) {
            this.setPosition(x - this.knightSprite.getWidth() / 2.0F, y - this.knightSprite.getHeight() / 2.0F);
        } else {
            this.setPosition(0.0F, 0.0F);
       }

    }
    }

