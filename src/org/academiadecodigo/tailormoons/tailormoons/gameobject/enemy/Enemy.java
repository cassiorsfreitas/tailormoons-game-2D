package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;

public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    private EnemyType enemyType;
    private final Rectangle rectangle;
    private Position position;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 35;
    private boolean rightDirection;

    public Enemy () {
        super(0,0,0,0);
        position = new Position(randomPositionX(), 550, WIDTH, HEIGHT);
        rectangle = new Rectangle(position.getX(), position.getY(), WIDTH, HEIGHT);
        rectangle.setColor(Color.MAGENTA);
        rectangle.fill();

        int randomDirection = (int) (Math.random() * 2);
        rightDirection = randomDirection == 0;
    }

    /**
     * This method generates predefined random positions for each enemy
     * @return
     */

    public int randomPositionX() {
        int earlyX = 0;
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
               earlyX = 200;
               break;
            case 1:
                earlyX = 400;
                break;
            case 2:
                earlyX = 450;
                break;
            case 3:
                earlyX = 600;
                break;
        }
        return earlyX;
    }

    @Override
    public void move() {
        int initialX = position.getX();
        int moveX = 0;
        int moveY = 0;

        if (rightDirection) {
            moveX = 1;
        } else {
            moveX = -1;
        }

        position.setCoordinates(moveX, moveY);
        rectangle.translate(position.getX() - initialX, 0);
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
}
