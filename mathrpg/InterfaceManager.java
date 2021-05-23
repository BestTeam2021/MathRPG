package com.ggteam.mathrpg;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
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


        interfaceStage.addActor(pauseMenuTable);
        interfaceStage.addActor(background);

    }

    void changeInterfaceState(String state) {
        interfaceStates = InterfaceStates.valueOf(state);
        switch (interfaceStates) {
            case GAME:
                pauseMenuTable.setVisible(false);
                background.setVisible(true);



                break;
            case PAUSE:
                pauseMenuTable.setVisible(true);
               // background.set;
                break;
            case BATTLE:
                pauseMenuTable.setVisible(false);
                // background.set;

                break;
        }
    }
}
