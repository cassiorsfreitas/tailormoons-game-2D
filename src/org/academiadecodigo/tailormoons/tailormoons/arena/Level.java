package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Sid;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Elevator;
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
    private GameObject[] gameObjects = new GameObject[50]; //PODE SER TROCADO POR LINKEDLIST

    public void createEntities(int level) {
        for (int i = 0; i < ConstantPosition.PLATFORMS_AMOUNT[level]; i++) {
            int x = ConstantPosition.PLATFORMS[level][i][0];
            int y = ConstantPosition.PLATFORMS[level][i][1];
            int width = ConstantPosition.PLATFORMS[level][i][2];
            int height = ConstantPosition.PLATFORMS[level][i][3];
            gameObjects[i] = new Platform(x, y, width, height);
            gameObjects[i].show();
        }

        for (int i = 0; i < ConstantPosition.LADDERS_AMOUNT[level]; i++) {
            int x = ConstantPosition.LADDERS[level][i][0];
            int y = ConstantPosition.LADDERS[level][i][1];
            int width = ConstantPosition.LADDERS[level][i][2];
            int height = ConstantPosition.LADDERS[level][i][3];
            gameObjects[ConstantPosition.PLATFORMS_AMOUNT[level] + i] = new Ladder(x, y, width, height);
            gameObjects[ConstantPosition.PLATFORMS_AMOUNT[level] + i].show();
        }

        for (int i = 0; i < ConstantPosition.KEYS_AMOUNT[level]; i++) {
            int x = ConstantPosition.KEYS[level][i][0];
            int y = ConstantPosition.KEYS[level][i][1];
            int width = ConstantPosition.KEYS[level][i][2];
            int height = ConstantPosition.KEYS[level][i][3];
            gameObjects[ConstantPosition.PLATFORMS_AMOUNT[level] + ConstantPosition.LADDERS_AMOUNT[level] + i] = new Key(x, y, width, height);
            gameObjects[ConstantPosition.PLATFORMS_AMOUNT[level] + ConstantPosition.LADDERS_AMOUNT[level] + i].show();
        }

        for (int i = 0; i < ConstantPosition.ELEVATORS_AMOUNT[level]; i++) {
            int x = ConstantPosition.ELEVATORS[level][i][0];
            int y = ConstantPosition.ELEVATORS[level][i][1];
            int width = ConstantPosition.ELEVATORS[level][i][2];
            int height = ConstantPosition.ELEVATORS[level][i][3];
            //NAO PERCEBO A LINHA DE BAIXO
            gameObjects[ConstantPosition.PLATFORMS_AMOUNT[level] + ConstantPosition.LADDERS_AMOUNT[level] + ConstantPosition.KEYS_AMOUNT[level] + i] = new Elevator(x, y, width, height);
            gameObjects[ConstantPosition.PLATFORMS_AMOUNT[level] + ConstantPosition.LADDERS_AMOUNT[level] + ConstantPosition.KEYS_AMOUNT[level] + i].show();
        }




        //TEMPORARY ENEMY
        //gameObjects[2] = new Sid();
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

}
