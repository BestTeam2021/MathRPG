package com.ggteam.mathrpg;

import com.sun.tools.javac.jvm.Items;

import java.awt.Image;
import java.awt.Label;

import javax.swing.text.html.ImageView;

public class Interface {
    private static String[] message = new String[5];
    static boolean inventory_shown = true;
    static int[] inventory = new int[10];
    static int[] equipment = new int[5];
    public Interface(Pane root) {
        statusBar(root);
        statusArea(root);
        buffs(root);
        inventory(root);
        equipment(root);
        IdScrolls(root);
    }

    static void newEvent(String message) {
        Interface.message[3] = Interface.message[2];
        Interface.message[2] = Interface.message[1];
        Interface.message[1] = Interface.message[0];
        Interface.message[0] = message;
    }

    static void newItem(int item) {
        if (inventory[9] == 0) {
            inventory[9] = inventory[8];
            inventory[8] = inventory[7];
            inventory[7] = inventory[6];
            inventory[6] = inventory[5];
            inventory[5] = inventory[4];
            inventory[4] = inventory[3];
            inventory[3] = inventory[2];
            inventory[2] = inventory[1];
            inventory[1] = inventory[0];
            inventory[0] = item;
        } else
            newEvent("Inventory full!");
    }
    private void statusBar(Pane root) {
        Image icons = new Image("status_bar.png");
        Label status_bar = new Label(
                "HP: " + Character.health_points + " / " + Character.max_health
                        + "\nSTR: " + Character.strength_points
                        + "\nDEX: " + Character.dexterity_points
                        + "\nDEF: " + Character.defence_points
                        + "\nEXP: " + Character.experience + " / " + Character.next_level
                        + "\nLVL: " + Character.level);
        status_bar.setGraphic(new ImageView(icons));
        status_bar.setAlignment(Pos.CENTER);
        status_bar.getStyleClass().add("status_bar.png");
        status_bar.setPadding(new Insets(20, 10, 20, 10));
        status_bar.setLayoutY(50);
        status_bar.layoutXProperty().bind(root.widthProperty()
                .subtract(status_bar.widthProperty()).subtract(20));
        root.getChildren().add(status_bar);
    }
    private void IdScrolls(Pane root) {
        if (inventory_shown) {
            Image scroll = new Image("scroll.png");
            Label scroll_counter = new Label(": " + Items.scrolls);
            scroll_counter.setGraphic(new ImageView(scroll));
            scroll_counter.setAlignment(Pos.CENTER);
            scroll_counter.getStyleClass().add("scrolls");
            scroll_counter.setPadding(new Insets(5));
            scroll_counter.setLayoutY(356);
            scroll_counter.layoutXProperty().bind(root.widthProperty()
                    .subtract(scroll_counter.widthProperty()).subtract(28));
            root.getChildren().add(scroll_counter);
        }
    }
    private void statusArea(Pane root) {
        Label status_area = new Label(
                message[3] + "\n"
                        + message[2] + "\n"
                        + message[1] + "\n"
                        + message[0]);
        status_area.setAlignment(Pos.CENTER);
        status_area.setPadding(new Insets(10, 50, 10, 50));
        status_area.getStyleClass().add("status_area");
        status_area.setLayoutX(60);
        status_area.layoutYProperty().bind(root.heightProperty()
                .subtract(status_area.heightProperty()).subtract(30));
        root.getChildren().add(status_area);
    }
}

