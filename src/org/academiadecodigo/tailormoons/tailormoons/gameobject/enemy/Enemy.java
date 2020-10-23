package org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.ConstantPosition;
import org.academiadecodigo.tailormoons.tailormoons.arena.Level;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;


public abstract class Enemy extends GameObject implements Movable {

    protected CollisionDetector collisionDetector;
    protected boolean rightDirection;
    private Position position;
    private final String assetRight;
    private final String assetLeft;


    //IMPLEMENT SOON
    //private EnemyType enemyType;

    public Enemy (int x, int y, int width, int height, int minMove, int maxMove, String assetRight, String assetLeft) {
        super(x,y,width,height, minMove, maxMove,  ((int) (Math.random() * 2)), assetRight, assetLeft);
        this.assetRight = assetRight;
        this.assetLeft = assetLeft;

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
            if (initialX == super.getMinMove()) {
                rightDirection = true;
                picture.load("assets/" + assetRight);
            }
        }

        if (rightDirection) {
            moveX = 1;
            if (initialX == super.getMaxMove()) {
                rightDirection = false;
                picture.load("assets/" + assetLeft);
            }
        }


        super.getPosition().setCoordinates(moveX, moveY);
        picture.translate(super.getPosition().getX() - initialX, 0);
    }


    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
}
