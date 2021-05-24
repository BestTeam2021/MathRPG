package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class InputManager {
    static Vector3 temp = new Vector3();


    public static void handleInput(OrthographicCamera camera) {
        if (Gdx.input.justTouched()) {
            temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp);
            float touchX = temp.x;
            float touchY = temp.y;
            for (Mob m : GameManager.mobs) {
                if (touchX > m.sprite.getX() && touchX < m.sprite.getX() + m.sprite.getWidth()) {
                    if (touchY > m.sprite.getY() && touchY < m.sprite.getY() + m.sprite.getHeight()) {
                        System.out.println("CLICK!");
                        InterfaceManager.getObject().changeInterfaceState("BATTLE");
                        return;
                    }
                }
            }
            GameManager.knight.setPosition(touchX, touchY);
            InterfaceManager.getObject().changeInterfaceState("GAME");
        }
    }
}
