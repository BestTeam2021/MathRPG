package com.ggteam.mathrpg;

import java.awt.Image;

import javax.swing.text.html.ImageView;

public class Actions {
    Actions(Pane root) {
        death(root);
    }

    private void death(Pane root) {

        if (Character.is_dead) {
            Image dead_screen = new Image("death_temporary");
            ImageView iV = new ImageView();
            iV.setFitHeight(AssetsLoader.tile_size * 11);
            iV.setFitWidth(AssetsLoader.tile_size * 11);
            iV.setImage(dead_screen);
            iV.setX(50);
            iV.setY(50);
            root.getChildren().add(iV);
        }
    }
}
