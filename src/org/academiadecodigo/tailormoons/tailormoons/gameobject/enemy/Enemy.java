package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;

import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;

public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    private EnemyType enemyType;

    public Enemy() {
        super(0,0,0,0); //MUDAR
    }


    @Override
    public void move() {

    }
}
