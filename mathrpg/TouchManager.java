
package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class TouchManager implements InputProcessor {
    OrthographicCamera camera;
    static Vector3 temp = new Vector3();

    public TouchManager(OrthographicCamera camera) {
    }

    public void InputManager(OrthographicCamera camera) {
        this.camera = camera;
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }



    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        temp.set((float)screenX, (float)screenY, 0.0F);
        this.camera.unproject(temp);
        float touchX = temp.x;
        float touchY = temp.y;
        GameManager.knight.setPosition(touchX, touchY);
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
