package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;

public abstract class Enemy extends GameObject implements Movable {

    private CollisionDetector collisionDetector;
    private EnemyType enemyType;
    private Rectangle rectangle;

    public Enemy () {
        rectangle = new Rectangle(300, 500, 35, 100);
        rectangle.setColor(Color.PINK);
        display();
    }

    public void display(){
        rectangle.fill();
    }

    @Override
    public void move() {
        rectangle.translate(1, 0);
    }
}
