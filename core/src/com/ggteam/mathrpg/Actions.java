package com.ggteam.mathrpg;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.text.html.ImageView;

public class Actions {
    Actions(Pane root) {
        death(root);
    }

    private void death(Pane root) {

        if (Knight.is_dead) {
            Image dead_screen = new Image("death_temporary") {
                @Override
                public int getWidth(ImageObserver observer) {
                    return 0;
                }

                @Override
                public int getHeight(ImageObserver observer) {
                    return 0;
                }

                @Override
                public ImageProducer getSource() {
                    return null;
                }

                @Override
                public Graphics getGraphics() {
                    return null;
                }

                @Override
                public Object getProperty(String name, ImageObserver observer) {
                    return null;
                }
            };
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
