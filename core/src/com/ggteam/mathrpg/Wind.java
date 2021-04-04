package com.ggteam.mathrpg;

public class Wind extends  Enemies {
    Wind (Room room, int positionX, int positionY) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.room = room;
        type = "Wind";
        enemy_type_tile = 72;
        health_points = 50;
        strength_points = 20;
        defence_points = 10;
        dexterity_points = 1;
        experience_points = 50;
        last_tile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 72;
    }
}