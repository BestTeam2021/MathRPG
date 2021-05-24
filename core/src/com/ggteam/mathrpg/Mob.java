package com.ggteam.mathrpg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Mob extends Person {

     public Mob() {
         super(100);
         texture = new Texture("fire_slime_pix.png");
        sprite = new Sprite(texture);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                System.out.println("IT WORKS!");
            }
        });
     }

}