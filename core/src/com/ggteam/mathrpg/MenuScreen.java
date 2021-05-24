
package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;




public class MenuScreen implements Screen {


    private Viewport viewport;
   // private Camera camera;
    Texture exitButtonTexture;
    Texture backGroundTexture;
    Texture MenuButtonTexture;
    Sprite MenuButtonSprite;
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
  // private Viewport viewport;
   private Stage stage;


    public void show() {
        this.backGroundTexture = new Texture(Gdx.files.internal("temporary_background.jpg"));
       this.backGroundSprite = new Sprite(this.backGroundTexture);
        this.exitButtonTexture = new Texture(Gdx.files.internal("ExitButton1.png"));
        this.exitButtonSprite = new Sprite(this.exitButtonTexture);
        this.startButtonTexture = new Texture(Gdx.files.internal("startButton.png"));
        this.startButtonSprite = new Sprite(this.startButtonTexture);
        this.MenuButtonTexture = new Texture(Gdx.files.internal("MenuButton1.png"));
        this.MenuButtonSprite = new Sprite(this.MenuButtonTexture);
        this.backGroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        startButtonSprite.setPosition(Gdx.input.getX() / 2, Gdx.input.getY() / 2);
        MenuButtonSprite.setPosition(Gdx.input.getX()/2, MenuButtonSprite.getHeight() / 2);
        exitButtonSprite.setPosition(Gdx.input.getX()/2 + 100, MenuButtonSprite.getHeight() / 2);



      camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
       viewport = new ScreenViewport(camera);

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
//
//
      this.backGroundSprite.draw(batch);
        this.startButtonSprite.draw(this.batch);
        this.exitButtonSprite.draw(this.batch);
        this.MenuButtonSprite.draw(this.batch);
        this.handleTouch();
        this.batch.end();
    }

    public void resize(int width, int height) {
         viewport.update(width, height);
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
        MenuButtonTexture.dispose();
        this.batch.dispose();
    }

    public MenuScreen(MainGame game) {
        this.height = (float)Gdx.graphics.getHeight();
        this.width = (float)Gdx.graphics.getWidth();
        this.camera = new OrthographicCamera(this.width, this.height);
        this.batch = new SpriteBatch();
        this.startButtonTexture = new Texture(Gdx.files.internal("startButton.png"));
        this.exitButtonTexture = new Texture(Gdx.files.internal("ExitButton.png"));
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
