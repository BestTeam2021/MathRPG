package com.ggteam.mathrpg;

public class Fire extends  Enemies {
    Fire (Room room, int positionX, int positionY) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.room = room;
        type = "Fire";
        enemy_type_tile = 70;
        health_points = 25;
        strength_points = 10;
        defence_points = 5;
        dexterity_points = 5;
        experience_points = 25;
        last_tile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 70;
    }
}
