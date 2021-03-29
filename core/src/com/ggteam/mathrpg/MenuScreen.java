
package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MenuScreen implements Screen {
    Texture exitButtonTexture;
    Texture backGroundTexture;
    Sprite startButtonSprite;
    Sprite exitButtonSprite;
    Sprite backGroundSprite;
    float height;
    float width;
    OrthographicCamera camera;
    SpriteBatch batch;
    Texture startButtonTexture;
    private static final float EXIT_VERT_POSITION_FACTOR = 4.2F;
    MainGame game;
    Vector3 temp;

    public void show() {
        this.backGroundTexture = new Texture(Gdx.files.internal("temporary_background.jpg"));
        this.backGroundSprite = new Sprite(this.backGroundTexture);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        this.backGroundSprite.draw(this.batch);
        this.handleTouch();
        this.batch.end();
    }

    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
        this.dispose();
    }

    public void dispose() {
        this.startButtonTexture.dispose();
        this.exitButtonTexture.dispose();
        this.batch.dispose();
    }

    public MenuScreen(MainGame game) {
        this.height = (float)Gdx.graphics.getHeight();
        this.width = (float)Gdx.graphics.getWidth();
        this.camera = new OrthographicCamera(this.width, this.height);
        this.batch = new SpriteBatch();
        this.startButtonTexture = new Texture(Gdx.files.internal("startButton.png"));
        this.temp = new Vector3();
        this.game = game;
    }

    void handleTouch() {
        if (Gdx.input.justTouched()) {
            this.temp.set((float)Gdx.input.getX(), (float)Gdx.input.getY(), 0.0F);
            this.camera.unproject(this.temp);
            float touchX = this.temp.x;
            float touchY = this.temp.y;
            if (touchX >= this.startButtonSprite.getX() && touchX <= this.startButtonSprite.getX() + this.startButtonSprite.getWidth() && touchY >= this.startButtonSprite.getY() && touchY <= this.startButtonSprite.getY() + this.startButtonSprite.getHeight()) {
                this.game.setScreen(new Adventure());
            } else if (touchX >= this.exitButtonSprite.getX() && touchX <= this.exitButtonSprite.getX() + this.exitButtonSprite.getWidth() && touchY >= this.exitButtonSprite.getY() && touchY <= this.exitButtonSprite.getY() + this.exitButtonSprite.getHeight()) {
                Gdx.app.exit();
            }
        }

    }
}
