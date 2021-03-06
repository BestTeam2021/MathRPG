package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PauseMenuButtons {
    private static PauseMenuButtons object;


    private TextButton[] textButtons;
    private Table pauseMenuTable;

    private PauseMenuButtons() {

        Skin skin = new Skin(Gdx.files.internal("myskin/myskin.json"));

        textButtons = new TextButton[]{
                new TextButton("continue", skin),
                new TextButton("exit", skin )
        };


        pauseMenuTable = new Table();
        pauseMenuTable.setFillParent(true);
        for (int i = 0; i < textButtons.length; i++) {
            textButtons[i].getLabel().getStyle().font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            textButtons[i].getLabel().setFontScale(1);
            switch (i) {
                case 0:
                    textButtons[i].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            InterfaceManager.getObject().changeInterfaceState("GAME");
                        }
                    });
                    break;
                case 1:
                    textButtons[i].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            InterfaceManager.getObject().changeInterfaceState("EXIT");
                        }
                    });
            }
            pauseMenuTable.add(textButtons[i]);
        }
        pauseMenuTable.center();
    }

    Table getPauseMenuTable() {
        return pauseMenuTable;
    }

    public static PauseMenuButtons getObject() {
        if (object == null) {
            object = new PauseMenuButtons();
        }
        return object;
    }

    public void dispose() {
        pauseMenuTable.clear();
        textButtons = null;
        object = null;
    }

    public static boolean isUsed() {
        return object != null;
    }
}
