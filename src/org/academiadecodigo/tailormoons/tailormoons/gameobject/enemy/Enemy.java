package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;

import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;

public abstract class Enemy extends GameObject implements Movable {

    private CollisionDetector collisionDetector;
    private EnemyType enemyType;


    @Override
    public void move() {

    }
}
