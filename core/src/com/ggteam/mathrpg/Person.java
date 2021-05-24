package com.ggteam.mathrpg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Person extends Actor {
    protected final int MAX_HP;
    protected int HP;
    protected int COIN;
    protected int EXP;
    protected int ATTACK ;
    protected Texture texture;
    protected Sprite sprite;
    protected boolean isAlive;
    protected int level = 1;

    protected Person(int max_hp) {
        MAX_HP = max_hp;
        HP = max_hp;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    protected boolean isAttacking;

    public enum State {
        NONE, BATTLE, DEAD
    }

    public State STATE;

    public void hit(int damage){ HP-=damage; }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

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

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
