package com.ggteam.mathrpg;


import java.util.Random;

public class Enemies {
    private Random generator = new Random();
    boolean is_under_attack = false;
    String type = "";
    Room room;
    int positionX, positionY = 0;
    int experience_points;
    int enemy_type_tile;
    int dexterity_points;
    int strength_points;

    int health_points;
    boolean isAlive() {
        if (this.health_points == 0) {
//            room.sizes[prevX][prevY] = last_tile;
            Interface.newEvent(type + " died");
//           Knight.coins(this.experience_points);
            if (generator.nextInt(3) == 0) {
                Drop drop = new Drop(positionX, positionY);
                room.drop_list.add(drop);
            }
            return false;
        }
        if (is_under_attack)
//            AssetsLoader.battle(this.positionX, this.positionY);
        is_under_attack = false;
        return true;
    }
    class Slime extends Enemies {

        Slime (Room room, int positionX, int positionY) {

            this.positionX = positionX;
            this.positionY = positionY;
            this.room = room;
            type = "Zombie";
            enemy_type_tile = 70;
            health_points = 25;
            strength_points = 10;
            experience_points = 25;
//            last_tile = room.sizes[positionX][positionY];
            room.sizes[positionX][positionY] = 70;
        }
    }


}
