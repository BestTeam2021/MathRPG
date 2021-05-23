
package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;



public class GameManager {
    public static Knight knight;
    static Texture knightTexture;
    public static Sprite brickwallSprite;
    public static Texture brickwallTexture;





    private static float KNIGHT_RESIZE_FACTOR = 3000.0F;
    public static SpriteBatch batch;

    public GameManager() {
    }

    public static void initialize(float width, float height) {
        knight = new Knight();
        knightTexture = new Texture(Gdx.files.internal("knight.png"));
        knight.knightSprite = new Sprite(knightTexture);
       knight.knightSprite.setSize(knight.knightSprite.getWidth() * (width / KNIGHT_RESIZE_FACTOR), knight.knightSprite.getHeight() * (width / KNIGHT_RESIZE_FACTOR));




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
        knight.render(batch);


    }
}
