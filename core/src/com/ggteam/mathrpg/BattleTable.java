package com.ggteam.mathrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Random;

import utils.ArithmeticGenerator;
import utils.Exercise;

public class BattleTable {
    private static BattleTable object;
    private Table battletable;
    private Label[]  answersLabel;






    private BattleTable () {
        com.ggteam.mathrpg.ArithmeticGenerator arithmeticGenerator = new com.ggteam.mathrpg.ArithmeticGenerator();
        com.ggteam.mathrpg.Exercise tack = arithmeticGenerator.getTask();
        String ex = tack.getLeft() + " " +  tack.getOperand().toChar() + " " + tack.getRight();
        String ans =  " " + "=" + " " + tack.getResult() ;
        Random random = new Random();
        int  a =    random.nextInt(11);

        String rndAns =  "   " + a + "";






        Skin skin = new Skin(Gdx.files.internal("myskin/myskin.json"));

        answersLabel = new Label[]{

                new Label( ex, skin),
                new Label(ans, skin ),
                new Label(rndAns,skin)
        };



        battletable = new Table();
        battletable.setFillParent(true);
        for (int i = 0; i <  answersLabel.length; i++) {
            answersLabel[i].getStyle().font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            answersLabel[i].setFontScale(1);

//            switch (i) {
//                case 0:
//                    answersLabel[i].addListener(new ClickListener() {
//                        @Override
//                        public void clicked(InputEvent event, float x, float y) {
//                            super.clicked(event, x, y);
//                            InterfaceManager.getObject().changeInterfaceState(qwe.toString());
//                        }
//                    });
//                    break;
//                case 1:
//                    answersLabel[i].addListener(new ClickListener() {
//                        @Override
//                        public void clicked(InputEvent event, float x, float y) {
//                            super.clicked(event, x, y);
//                            InterfaceManager.getObject().changeInterfaceState("EXIT");
//                        }
//                    });
//            }
            battletable.add( answersLabel[i]);
        }
        battletable.center();
    }



    public Table getBattletable() {
        return battletable;
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

