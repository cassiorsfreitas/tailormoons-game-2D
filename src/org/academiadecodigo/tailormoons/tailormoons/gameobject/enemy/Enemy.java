package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;

import java.util.Random;

public abstract class Enemy extends GameObject implements Movable {

    private CollisionDetector collisionDetector;
    private EnemyType enemyType;
    private Rectangle rectangle;
    private boolean rightDirection;

    public Enemy () {
        rectangle = new Rectangle(300, 500, 35, 100);
        rectangle.setColor(Color.PINK);
        display();

        int randomDirection = (int) (Math.random() * 2);
        rightDirection = randomDirection == 0;
    }

    public void display(){
        rectangle.fill();
    }

    @Override
    public void move() {
        if (rightDirection) {
            rectangle.translate(1, 0);
        } else {
            rectangle.translate(-1, 0);
        }
    }
}
