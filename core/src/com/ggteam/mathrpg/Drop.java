package com.ggteam.mathrpg;

import java.util.Random;

public class Drop {
    int x_position;
    int y_position;
    private int treasure;

    Drop(int x_position, int y_position) {
        this.x_position = x_position;
        this.y_position = y_position;

        Random generator = new Random();
        int random = generator.nextInt(140);


     if (random < 90)
            treasure = 8;
        else if (random < 110)
            treasure = 9;
        else if (random < 115)
            treasure = 10;

    }

    Drop(int x_position, int y_position, int treasure) {
        this.x_position = x_position;
        this.y_position = y_position;

         if (treasure == 8 || treasure == 9 || treasure == 10)
            this.treasure = treasure;
        else if (treasure >= 11 && treasure <= 16)
            this.treasure = treasure;
        else if (treasure == 21 || treasure == 22 || treasure == 23)
            this.treasure = treasure;
        else if (treasure == 31 || treasure == 32 || treasure == 33)
            this.treasure = treasure;
        else if (treasure == 41 || treasure == 42 || treasure == 43)
            this.treasure = treasure;
    }

        void checkTreasure () {
            if (treasure == 8 || treasure == 9 || treasure == 10)
            Interface.newItem(treasure);
        else if (treasure >= 11 && treasure <= 16)
            Interface.newItem(treasure);
        else if (treasure == 21 || treasure == 22 || treasure == 23)
            Interface.newItem(treasure);
        else if (treasure == 31 || treasure == 32 || treasure == 33)
            Interface.newItem(treasure);
        else if (treasure == 41 || treasure == 42 || treasure == 43)
            Interface.newItem(treasure);
        }
    }
