package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Adventure implements Screen {
    SpriteBatch batch;
    OrthographicCamera camera;

    public Adventure() {
    }

    public void show() {
        float height = (float)Gdx.graphics.getHeight();
        float width = (float)Gdx.graphics.getWidth();
        this.camera = new OrthographicCamera(width, height);
        this.camera.setToOrtho(false);
        this.batch = new SpriteBatch();
        GameManager.initialize(width, height);

    }

    public void resize(int width, int height) {

    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
    }

    public void dispose() {
        this.batch.dispose();
        GameManager.dispose();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        GameManager.renderGame(this.batch);
        this.batch.end();
        InputManager.handleInput(camera);
    }
}
