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
    private static final int HEIGHT = 100;
    private static final int WIDTH = 35;
    private final int speed = 10;
    private final int maxJump = 75;
    private final int gravityAcceleration = 10;

    private CollisionDetector collisionDetector;

    private boolean isJumping;
    private int keyPressed;
    private int initialY;

    public Player() {
        position = new Position(400, 500);
        rectangle = new Rectangle(position.getX(), position.getY(), WIDTH, HEIGHT);
        rectangle.setColor(Color.MAGENTA);
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

        switch (keyPressed) {
            case KeyboardEvent.KEY_UP:
                this.initialY = position.getY();
                moveY = moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;

            case KeyboardEvent.KEY_LEFT:
                moveX = position.getX() + (Direction.LEFT.x * speed);
                break;

            case KeyboardEvent.KEY_RIGHT:
                moveX = position.getX() + (Direction.RIGHT.x * speed);
                break;

            default:
                break;
        }

        gravity = gravity();


        rectangle.translate(moveX, moveY+gravity);

        keyPressed = 0;

    }


    private int moveUp() {

        isJumping = true;

        if (position.getY() <= initialY - maxJump) {
            isJumping = false;
            return 0;
        }

        return Direction.UP.y * 10;

    }


    private void moveDown() {

    }


    private int gravity() {
        if (isJumping) {
            return 0 ;
        }

        return gravityAcceleration;

    }


    @Override
    public void setKeyPressed(int keyPressed) {
        this.keyPressed = keyPressed;
    }

}
