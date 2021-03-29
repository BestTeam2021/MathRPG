
package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager {
    public static Knight knight;
    static Texture knightTexture;
    public static Sprite backgroundSprite;
    public static Texture backgroundTexture;
    private static float KNIGHT_RESIZE_FACTOR = 3000.0F;
    public static SpriteBatch batch;

    public GameManager() {
    }

    public static void initialize(float width, float height) {
        knight = new Knight();
        knightTexture = new Texture(Gdx.files.internal("basket.png"));
        knight.knightSprite = new Sprite(knightTexture);
        knight.knightSprite.setSize(knight.knightSprite.getWidth() * (width / KNIGHT_RESIZE_FACTOR), knight.knightSprite.getHeight() * (width / KNIGHT_RESIZE_FACTOR));
        knight.setPosition(width / 2.0F, height / 2.0F);
        backgroundTexture = new Texture(Gdx.files.internal("temporary_background.jpg"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(width, height);
    }

    public static void dispose() {
        backgroundTexture.dispose();
        knightTexture.dispose();
    }

    public static void renderGame(SpriteBatch batch) {
        backgroundSprite.draw(batch);
        knight.render(batch);
    }
}
