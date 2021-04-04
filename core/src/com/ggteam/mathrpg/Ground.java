package com.ggteam.mathrpg;

public class Ground extends Enemies {
    Ground (Room room, int positionX, int positionY) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.room = room;
        type = "Ground";
        enemy_type_tile = 73;
        health_points = 5;
        strength_points = 5;
        defence_points = 1;
        dexterity_points = 90;
        experience_points = 10;
        last_tile = room.sizes[positionX][positionY];
        room.sizes[positionX][positionY] = 73;
    }

}
