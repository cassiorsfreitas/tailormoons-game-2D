package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;

public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    private EnemyType enemyType;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 35;
    private boolean rightDirection;

    public Enemy (int x, int y, int width, int height) {
        super(x,y,width,height);

        int randomDirection = (int) (Math.random() * 2);
        rightDirection = randomDirection == 0;
    }

    /**
     * This method generates predefined random direction for each enemy
     * @return
     */
    @Override
    public void move() {
        int initialX = super.getPosition().getX();
        int moveX = 0;
        int moveY = 0;

        if (rightDirection) {
            moveX = 1;
        } else {
            moveX = -1;
        }

        super.getPosition().setCoordinates(moveX, moveY);
        rectangle.translate(super.getPosition().getX() - initialX, 0);
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
}
