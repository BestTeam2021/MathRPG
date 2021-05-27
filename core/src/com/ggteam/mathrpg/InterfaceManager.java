package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class InterfaceManager {
    private static InterfaceManager object;

    private Stage interfaceStage;
    private InterfaceStates interfaceStates;
    private Table actionTable, pauseMenuTable, battleTable;
    private Actor background;
    public static MainGame game;

    public static InterfaceManager getObject() {
        if (object == null) {
            object = new InterfaceManager();
        }
        return object;
    }


    private enum InterfaceStates {
        GAME, PAUSE, BATTLE
    }

    private InterfaceManager() {
        interfaceStage = new Stage(MainGame.getViewportInterfaceStage());
        pauseMenuTable = PauseMenuButtons.getObject().getPauseMenuTable();
        background = Background.getObject().getBackground();
        battleTable = BattleTable.getObject().getBattletable();

        Skin skin = new Skin(Gdx.files.internal("myskin/myskin.json"));
        battleTable.setSkin(skin);
        battleTable.setPosition(Gdx.graphics.getWidth() / 2 - 100 , Gdx.graphics.getHeight() / 2 - 100);


        interfaceStage.addActor(pauseMenuTable);
        interfaceStage.addActor(background);

        changeInterfaceState("GAME");
    }

    void changeInterfaceState(String state) {
        interfaceStates = InterfaceStates.valueOf(state);
        switch (interfaceStates) {
            case GAME:
                pauseMenuTable.setVisible(false);
                background.setVisible(true);
                battleTable.setVisible(false);
                break;
            case PAUSE:
                pauseMenuTable.setVisible(true);
                battleTable.setVisible(false);
               // background.set;
                break;
            case BATTLE:
                pauseMenuTable.setVisible(false);
                background.setVisible(false);
                battleTable.setVisible(true);
                // background.set;

                break;
        }
    }

    public void act(float delta) {
        pauseMenuTable.act(delta);
    }

    public void draw(SpriteBatch spriteBatch) {
        if (pauseMenuTable.isVisible())
            pauseMenuTable.draw(spriteBatch, 1);
        if (battleTable.isVisible())
            battleTable.draw(spriteBatch, 1);
    }
}
