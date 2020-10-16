package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Sid;

public class Level {

    private ConstantPosition constantPosition;
    private GameObject[] gameObjects = new GameObject[20];

    public Level() {
        gameObjects[0] = new Sid();
    }


    public void createEntities(int level) {

    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }
}
