package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ggteam.mathrpg.MainGame;
import com.ggteam.mathrpg.Mob;

import java.awt.Button;
import java.util.ArrayList;

public class GameScreen implements Screen {

    private SpriteBatch batch;

    public GameScreen() {
    }

    public void gameScreen(MainGame game) {
//        Button exitBtn = new Button();
//        stage.addActor(exitBtn);

    }

    class GameActor extends Actor{

    }

    @Override
    public void show() {
        batch = new SpriteBatch();




    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        batch.dispose();

    }
}
