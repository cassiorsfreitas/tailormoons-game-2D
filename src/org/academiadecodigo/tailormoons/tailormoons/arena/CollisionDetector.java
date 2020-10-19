package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;

public class CollisionDetector {

    private GameObject[] gameObjects;

    public CollisionDetector(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }


    public boolean hasCollision() {
        return false;
    }

}
