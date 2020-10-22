package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;


public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    private EnemyType enemyType;
    private Rectangle rectangle;
    private boolean rightDirection;

    public Enemy () {
        super(0,0,0,0, "playerLeft1.png");
        newEnemy();
        display();

        int randomDirection = (int) (Math.random() * 2);
        rightDirection = randomDirection == 0;
    }

    public Rectangle newEnemy(){
        rectangle = new Rectangle(randomPositionX(), 500, 25, 50);
        rectangle.setColor(Color.PINK);
        return rectangle;
    }

    public void display(){
        rectangle.fill();
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
        if (rightDirection) {
            rectangle.translate(1, 0);
        } else {
            rectangle.translate(-1, 0);
        }
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
}
