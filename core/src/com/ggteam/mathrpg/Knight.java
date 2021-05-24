package com.ggteam.mathrpg;


public class Knight  extends  Person {

    public Knight() {
        super(200);
    }


    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public void handleTouch(float x, float y) {
        if ((double)(x - sprite.getWidth() / 2.0F) > 0.0D) {
            this.setPosition(x - sprite.getWidth() * 2.0F, y - sprite.getHeight() * 2.0F);
        } else {
            this.setPosition(0.0F, 0.0F);
       }

    }

    }



