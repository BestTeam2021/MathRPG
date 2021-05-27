package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import utils.ArithmeticGenerator;
import utils.Exercise;

public class BattleTable {
    private static BattleTable object;
    private Table battletable;
    private Label[]  answersLabel;


    private BattleTable () {

        Skin skin = new Skin(Gdx.files.internal("myskin/myskin.json"));

        answersLabel = new Label[]{

                new Label("exercise", skin),
                new Label("answers", skin )
        };
      final Exercise qwe = new ArithmeticGenerator().getTask();
      Exercise answer = new Exercise();
        battletable = new Table();
        battletable.setFillParent(true);
        for (int i = 0; i <  answersLabel.length; i++) {
            answersLabel[i].getStyle().font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            answersLabel[i].setFontScale(1);
            switch (i) {
                case 0:
                    answersLabel[i].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            InterfaceManager.getObject().changeInterfaceState(qwe.toString());
                        }
                    });
                    break;
                case 1:
                    answersLabel[i].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            InterfaceManager.getObject().changeInterfaceState("EXIT");
                        }
                    });
            }
            battletable.add( answersLabel[i]);
        }
        battletable.center();
    }



    public static BattleTable getObject() {
        if (object == null) {
            object = new BattleTable();
        }
        return object;
    }

    public void dispose() {
        battletable.clear();
        answersLabel = null;
        object = null;
    }

    public static boolean isUsed() {
        return object != null;
    }
}

