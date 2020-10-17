package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;

import java.util.Random;

public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    private EnemyType enemyType;
    private final Rectangle rectangle;
    private Position position;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 35;
    private final int speed = 1;
    private boolean rightDirection;
    private boolean left;
    private boolean right;
    private int initialY;

    public Enemy () {
        super(0,0,0,0);
        position = new Position(randomPositionX(), 550, WIDTH, HEIGHT);
        rectangle = new Rectangle(position.getX(), position.getY(), WIDTH, HEIGHT);
        rectangle.setColor(Color.MAGENTA);
        rectangle.fill();

        int randomDirection = (int) (Math.random() * 2);
        rightDirection = randomDirection == 0;
    }

    public int randomPositionX() {
        int earlyX = 0;
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
               earlyX = 200;
               break;
            case 1:
                earlyX = 400;
            case 2:
                earlyX = 450;
            case 3:
                earlyX = 600;
                break;
        }
        return earlyX;
    }

    @Override
    public void move() {
        int moveX = 1;
        int moveY = 1;
        int initialX = position.getX();
        int initialY = position.getY();
        position.setCoordinates(moveX, moveY);
        if (rightDirection) {
            rectangle.translate(position.getX() - initialX, position.getY() - initialY);
        } else {
            rectangle.translate(-(position.getX()), position.getY() - initialY);
        }
    }
}
