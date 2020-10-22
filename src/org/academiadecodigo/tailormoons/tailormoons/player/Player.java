package org.academiadecodigo.tailormoons.tailormoons.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;
import org.academiadecodigo.tailormoons.tailormoons.handler.Interactable;

/**
 * All the interaction with the player are implemented here. The player are delegated to move and ask collisionDetector for all possible collisions.
 */
public class Player implements Movable, Interactable {

    /**
     * Picture of the player that will be translated over time.
     */
    private Picture picture;

    /**
     * Position of the player over time. From time Position class.
     */
    private final Position position;

    /**
     * Height and Width of the player. They are static proprieties because any class can get those information.
     */
    private static final int HEIGHT = 50;
    private static final int WIDTH = 23;

    /**
     * All the stats of the player.
     *
     * @var speed: Have the speed of the player. Greater values means greater speed of the player. (1 is already fast)
     * @var maxJump: When the jump is performed, this value is used to know how much the player are able to jump from it's starting point.
     * @var gravityAcceleration: The player will fall from a surface at a determined speed rate. (Might be greater that 1)
     */
    private final int speed = 1;
    private final int maxJump = 75;
    private final int gravityAcceleration = 1;

    /**
     * The player have a CollisionDetector to help him know what is he touching.
     */
    private CollisionDetector collisionDetector;

    /**
     * Auxiliaries to help the player know what state is he in at the moment.
     */
    private boolean isJumping;
    private boolean isFalling;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean isDead;
    private boolean isOverCat;
    private boolean goingRight = true;

    private GameObject keyTaken = null;

    private int steps = 1;
    private int stepsUp = 1;
    private int pixelSteps;
    private int jumped;
    private int jumpTimer;
    private int fell;
    private int fallTimer;


    /**
     * Constructor of player. It builds the picture of the player
     */
    public Player() {
        position = new Position(400, 550, WIDTH, HEIGHT);

    }


    /**
     * Display the player picture.
     */
    public void display() {
        picture = new Picture(position.getX(), position.getY(), "assets/playerRight1.png");
        picture.draw();
    }


    /**
     * Override move from interface Movable. The class knows what key has been pressed so the move() use this key in order to make
     * the moves. Always checking if the move is possible in order to execute the move.
     */
    @Override
    public void move() {

        int initialX = position.getX();
        int initialY = position.getY();
        int moveX = 0;
        int moveY = 0;

        if (isJumping) {
            moveY = moveUp();
        }

        if (up) {
            if (!isJumping && !isFalling) {
                moveY = moveUp();
            }
        }
        if (down) {
            if (!isJumping && !isFalling) {
                moveY = moveDown();
            }
        }
        if (left) {
            if (collisionDetector.canMove(position, Direction.LEFT)) {
                moveX = Direction.LEFT.x * speed;
            }
        }
        if (right) {
            if (collisionDetector.canMove(position, Direction.RIGHT)) {
                moveX = Direction.RIGHT.x * speed;
            }
        }

        verifyMove(moveX, moveY, initialX, initialY);

    }


    /**
     * This method verify every movement the player will have so
     *
     * @param moveX
     * @param moveY
     * @param initialX
     * @param initialY
     */
    private void verifyMove(int moveX, int moveY, int initialX, int initialY) {

        int gravity;

        gravity = gravity();

        if (pixelSteps == 25) {
            pixelSteps = 0;
            changePicture(moveX, moveY);
        }
        pixelSteps++;

        position.setCoordinates(moveX, moveY + gravity);

        picture.translate(position.getX() - initialX, position.getY() - initialY);


        if (collisionDetector.hasEnemyCollision(position)) {
            isDead = true;
            picture.load("playerDied.png");
            return;
        }

        GameObject key = collisionDetector.hasKeyCollision(position);
        if (key != null) {
            keyTaken = key;
        }

        if (collisionDetector.hasCatCollision(position)) {
            isOverCat = true;
        } else {
            isOverCat = false;
        }

    }


    /**
     * Change the picture of the player while it moves
     *
     * @param moveX
     * @param moveY
     */
    private void changePicture(int moveX, int moveY) {

        if (collisionDetector.hasLadderCollision(position)) {

            steps = 0;

            if (moveY != 0) {

                if (stepsUp++ > 1) {
                    stepsUp = 1;
                }

                switch (stepsUp) {
                    case 1:
                        picture.load("playerUpRight.png");
                        return;

                    case 2:
                        picture.load("playerUpLeft.png");
                        return;
                }

            }

            return;
        }

        if (moveX > 0) {
            if (goingRight) {
                steps++;
                if (steps == 3) {
                    steps = 1;
                }
            } else {
                goingRight = true;
                steps = 1;
            }
        } else if (moveX < 0) {
            if (!goingRight) {
                steps++;
                if (steps == 3) {
                    steps = 1;
                }
            } else {
                goingRight = false;
                steps = 1;
            }
        } else {
            steps = 0;
        }

        switch (steps) {
            case 0:
                if (goingRight) {
                    picture.load("playerRight1.png");
                    return;
                }
                picture.load("playerLeft1.png");
                return;

            case 1:
                if (goingRight) {
                    picture.load("playerRight2.png");
                    return;
                }
                picture.load("playerLeft2.png");
                return;

            case 2:
                if (goingRight) {
                    picture.load("playerRight3.png");
                    return;
                }
                picture.load("playerLeft3.png");
        }
    }


    /**
     * moveUp() is executed when the key UP has been pressed. if the CollisionDetector detects a ladder, the moveUp will climb up the ladder.
     * Otherwise it will perform a jump.
     *
     * @return moveY
     */
    private int moveUp() {

        if (collisionDetector.hasLadderCollision(position)) {
            isJumping = false;
            jumped = 0;
            if (collisionDetector.canMoveUp(position)) {
                return Direction.UP.y;
            }
            return 0;
        }

        if (jumped >= maxJump || position.getY() == 0 || !collisionDetector.canMoveUp(position)) {
            jumped = 0;
            //FALL
            isJumping = false;
            isFalling = true;
            return 0;
        }

        isJumping = true;

        if (jumped >= 60) {
            jumpTimer++;
            if (jumpTimer >= 3) {
                jumpTimer = 0;
                jumped++;
                return Direction.UP.y;
            }
            return 0;
        }

        if (jumped >= 30) {
            jumpTimer++;
            if (jumpTimer >= 2) {
                jumpTimer = 0;
                jumped++;
                return Direction.UP.y;
            }
            return 0;
        }

        jumped++;

        return Direction.UP.y;
    }


    /**
     * The moveDown() will only be called if the player is not jumping neither falling.
     * It will only return a moveY if it is on a ladder and will climb down the same ladder.
     *
     * @return moveY
     */
    private int moveDown() {
        if (!collisionDetector.hasLadderCollision(position) || !collisionDetector.hasGravity(position)) {
            return 0;
        }
        return Direction.DOWN.y;
    }


    /**
     * If the player has always a gravity. But will only be a value different from 0 if there is no ladder, platform
     * under him. It will be 0 as well if the player is performing a jump.
     *
     * @return moveY
     */
    private int gravity() {
        if (isJumping || !collisionDetector.hasGravity(position) || collisionDetector.hasLadderCollision(position)) {
            fell = 0;
            isFalling = false;
            return 0;
        }

        isFalling = true;

        if (fell <= 30) {
            fallTimer++;
            if (fallTimer >= 3) {
                fallTimer = 0;
                fell++;
                return Direction.DOWN.y;
            }
            return 0;
        }

        if (fell <= 60) {
            fallTimer++;
            if (fallTimer >= 2) {
                fallTimer = 0;
                fell++;
                return Direction.DOWN.y;
            }
            return 0;
        }

        fell++;

        return Direction.DOWN.y;
    }


    /**
     * There is always another tread checking for KeyPressed and KeyReleases events. If those methods are triggered,
     * they will set the key to true.
     * Method setKey() takes the job to get the key pressed and the state to set the respective key as pressed or not.
     *
     * @param key
     * @param state
     */
    @Override
    public void setKey(int key, boolean state) {
        switch (key) {
            case KeyboardEvent.KEY_UP -> up = state;
            case KeyboardEvent.KEY_DOWN -> down = state;
            case KeyboardEvent.KEY_LEFT -> left = state;
            case KeyboardEvent.KEY_RIGHT -> right = state;
        }
    }


    /**
     * setCollisionDetector() is used by Arena to instantiate a CollisionDetector. Arena will give all gameObjects[]
     * to the CollisionDetector and give this CollisionDetector to the player.
     */
    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }


    /**
     * Returns if the player is dead or not.
     *
     * @return isDead
     */
    public boolean isDead() {
        return isDead;
    }


    /**
     * Return the key that was taken.
     *
     * @return GameObject
     */
    public GameObject getKeyTaken() {
        return keyTaken;
    }


    /**
     * Method to reset the keyTaken to null.
     */
    public void resetKeyTaken() {
        keyTaken = null;
    }


    /**
     * Get if the parameter that says if the player is OverCat. Calculated on verifyMove().
     *
     * @return
     */
    public boolean getIsOverCat() {
        return isOverCat;
    }
}
