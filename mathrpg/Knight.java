package com.ggteam.mathrpg;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ListIterator;


public class Knight  extends  Person {
    public Sprite knightSprite;
    static int maxHP= 200;
    static int HP = 200;
    static int level = 1;
    static boolean is_dead = false;
    static boolean is_attacking = false;
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
            this.setPosition(x - this.knightSprite.getWidth() * 2.0F, y - this.knightSprite.getHeight() * 2.0F);
        } else {
            this.setPosition(0.0F, 0.0F);
       }

    }

    }



