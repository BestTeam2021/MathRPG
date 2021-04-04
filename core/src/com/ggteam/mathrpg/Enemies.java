package com.ggteam.mathrpg;



import java.util.Random;

public class Enemies {}
    private Random generator = new Random();
    boolean is_under_attack = false;
    String type = "";
    Room room;
    int positionX, positionY = 0;
    private int prevX, prevY;
    int experience_points;
    int enemy_type_tile;
    int dexterity_points;
    int strength_points;
    int defence_points;
    int health_points;
    int last_tile;

    boolean isAlive() {
        if (this.health_points == 0) {
            room.sizes[prevX][prevY] = last_tile;
            Interface.newEvent(type + " died");
            Character.experience(this.experience_points);
            if (generator.nextInt(3) == 0) {
                Drop drop = new Drop(positionX, positionY);
                room.drop_list.add(drop);
            }
            return false;
        }
        if (is_under_attack)
            AssetsLoader.battle(this.positionX, this.positionY);
        is_under_attack = false;
        return true;
    }
}