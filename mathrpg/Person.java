package com.ggteam.mathrpg;

import com.badlogic.gdx.graphics.Texture;

public class Person {
    private int HP;
    private int COIN;
    private int EXP;
    private int ATTACK ;
    private Texture texture;
    private boolean isAlive;
    public void hit(int damage){ HP-=damage; }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getCOIN() {
        return COIN;
    }

    public void setCOIN(int COIN) {
        this.COIN = COIN;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getATTACK() {
        return ATTACK;
    }

    public void setATTACK(int ATTACK) {
        this.ATTACK = ATTACK;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
