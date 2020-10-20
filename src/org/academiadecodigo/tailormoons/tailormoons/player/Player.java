package org.academiadecodigo.tailormoons.tailormoons.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;
import org.academiadecodigo.tailormoons.tailormoons.handler.Interactable;

public class Player implements Movable, Interactable {

    //Change to picture
    private final Rectangle rectangle;
    private Position position;
    private static final int HEIGHT = 75;
    private static final int WIDTH = 35;
    private final int speed = 1;
    private final int maxJump = 75;
    private final int gravityAcceleration = 1;

    private CollisionDetector collisionDetector;

    private boolean isJumping;
    private boolean isFalling;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int initialY;

    public Player() {
        position = new Position(400, 400, WIDTH, HEIGHT);
        rectangle = new Rectangle(position.getX(), position.getY(), WIDTH, HEIGHT);
        rectangle.setColor(Color.MAGENTA);
        // Hiding the player to test
        rectangle.draw();
    }


    @Override
    public void move() {

        int initialX = position.getX();
        int initialY = position.getY();
        int moveX = 0;
        int moveY = 0;
        int gravity = 0;

        if (isJumping) {
            moveY = moveUp();
        }

        if (up) {
            if (!isJumping) {
                this.initialY = position.getY();
                moveY = moveUp();
            }
        }
        if (down) {
            moveDown();
        }
        if (left) {
            moveX = Direction.LEFT.x * speed;
        }
        if (right) {
            moveX = Direction.RIGHT.x * speed;
        }


        if (collisionDetector.hasGravity(position)) {
            gravity = gravity();
        }

        position.setCoordinates(moveX, moveY + gravity);

        rectangle.translate(position.getX() - initialX, position.getY() - initialY);

    }


    private int moveUp() {

        isJumping = true;

        if (position.getY() <= initialY - maxJump || position.getY() == 0) {
            isJumping = false;
            return 0;
        }
        return Direction.UP.y;
    }


    private void moveDown() {

    }


    private int gravity() {
        if (isJumping || !collisionDetector.hasGravity(position)) {
            return 0;
        }
        return gravityAcceleration;
    }


    @Override
    public void setKey(int key, boolean state) {
        switch (key) {
            case KeyboardEvent.KEY_UP:
                up = state;
                break;

            case KeyboardEvent.KEY_DOWN:
                down = state;
                break;

            case KeyboardEvent.KEY_LEFT:
                left = state;
                break;

            case KeyboardEvent.KEY_RIGHT:
                right = state;
                break;
        }
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

}
