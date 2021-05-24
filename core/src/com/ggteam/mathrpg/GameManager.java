
package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;


public class GameManager {
    public static Knight knight;
    static Texture knightTexture;
    public static Sprite brickwallSprite;
    public static Texture brickwallTexture;
    public static ArrayList<Mob> mobs;

    private static float KNIGHT_RESIZE_FACTOR = 3000.0F;
    private static float MOB_RESIZE_FACTOR = 3000.0F;
    public static SpriteBatch batch;

    public GameManager() {

    }

    public static void initialize(float width, float height) {
        mobs = new ArrayList<>();
        mobs.add(new Mob());

        knight = new Knight();
        knightTexture = new Texture(Gdx.files.internal("knight.png"));
        knight.sprite= new Sprite(knightTexture);
       knight.sprite.setSize(knight.sprite.getWidth() * (width / KNIGHT_RESIZE_FACTOR), knight.sprite.getHeight() * (width / KNIGHT_RESIZE_FACTOR));

        for (Mob m: mobs) {
            m.sprite.setSize(m.sprite.getWidth() * (width / MOB_RESIZE_FACTOR), m.sprite.getHeight() * (width / MOB_RESIZE_FACTOR));
            m.sprite.setPosition(200, 200);
        }

        knight.setPosition(width / 2.0F, height / 2.0F);
        brickwallTexture = new Texture(Gdx.files.internal("temporary_background.jpg"));
        brickwallSprite = new Sprite(brickwallTexture);
        brickwallSprite.setSize(width, height);

    }

    public static void dispose() {
        brickwallTexture.dispose();
        knightTexture.dispose();

    }

    public static void renderGame(SpriteBatch batch) {
        brickwallSprite.draw(batch);
        for (Mob m: mobs) {
            m.render(batch);
        }
        knight.render(batch);
        InterfaceManager.getObject().draw(batch);
    }
}
