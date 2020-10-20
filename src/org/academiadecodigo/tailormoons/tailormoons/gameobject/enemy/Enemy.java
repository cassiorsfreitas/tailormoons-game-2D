package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.ConstantPosition;
import org.academiadecodigo.tailormoons.tailormoons.arena.Level;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;


public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    private boolean rightDirection;
    private Position position;

    //IMPLEMENT SOON
    //private EnemyType enemyType;


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

        if (!rightDirection){
            moveX = -1;
            if (initialX == 0) {
                rightDirection = true;
            }
        }

        if (rightDirection) {
            moveX = 1;
            if (initialX == 800 - super.getPosition().getWidth()) {
                rightDirection = false;
            }
        }


        super.getPosition().setCoordinates(moveX, moveY);
        rectangle.translate(super.getPosition().getX() - initialX, 0);
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
}
