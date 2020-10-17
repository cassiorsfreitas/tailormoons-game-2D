package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Sid;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Key;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Ladder;
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
        for (int i = 0; i < ConstantPosition.PLATFORMS_AMOUNT[level]; i++) {
            int x = ConstantPosition.PLATFORMS[i][0];
            int y = ConstantPosition.PLATFORMS[i][1];
            int width = ConstantPosition.PLATFORMS[i][2];
            int height = ConstantPosition.PLATFORMS[i][3];
            gameObjects[i] = new Platform(x, y, width, height);
            gameObjects[i].show();
        }

        for (int i = 0; i < ConstantPosition.LADDERS_AMOUNT[level]; i++) {
            int x = ConstantPosition.LADDERS[i][0];
            int y = ConstantPosition.LADDERS[i][1];
            int width = ConstantPosition.LADDERS[i][2];
            int height = ConstantPosition.LADDERS[i][3];
            gameObjects[i] = new Ladder(x, y, width, height);
            gameObjects[i].show();
        }

        for (int i = 0; i < ConstantPosition.KEYS_AMOUNT[level]; i++) {
            int x = ConstantPosition.KEYS[i][0];
            int y = ConstantPosition.KEYS[i][1];
            int width = ConstantPosition.KEYS[i][2];
            int height = ConstantPosition.KEYS[i][3];
            gameObjects[i] = new Key(x, y, width, height);
            gameObjects[i].show();
        }



        //TEMPORARY ENEMY
        //gameObjects[2] = new Sid();
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

}
