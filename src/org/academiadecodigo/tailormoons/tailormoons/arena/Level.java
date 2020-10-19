package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Sid;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Platform;

/**
 * Level is a class where entities of GameObjects are going to be created.
 * It is responsible to generate the level that is being played by the Player.
 */
public class Level {

    /**
     *
     */
    private GameObject[] gameObjects = new GameObject[5]; //PODE SER TROCADO POR LINKEDLIST

    public void createEntities(int level) {
        for (int i = 0; i < ConstantPosition.PLATFORMS_AMOUNT[level-1]; i++) {
            int x = ConstantPosition.PLATFORMS[i][0];
            int y = ConstantPosition.PLATFORMS[i][1];
            int width = ConstantPosition.PLATFORMS[i][2];
            int height = ConstantPosition.PLATFORMS[i][3];
            gameObjects[i] = new Platform(x, y, width, height);
            gameObjects[i].show();
        }

        //TEMPORARY ENEMY
        //gameObjects[2] = new Sid();
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

}
