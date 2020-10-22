package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.cat.Cat;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Key;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Ladder;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Platform;

import java.util.LinkedList;

/**
 * CollisionDetector detects all collisions that happens between the Player/Enemy with platforms, keys and ladders.
 */
public class CollisionDetector {

    /**
     * Array of all GameObjects used in this level.
     */
    private final LinkedList<GameObject> gameObjects;

    /**
     * Constructor of CollisionDetector. It will instantiate the array gameObjects with all the gameObjects that are in
     * parameters.
     *
     * @param gameObjects
     */
    public CollisionDetector(LinkedList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }


    /**
     * This method return if the entity that call it has gravity or not. It uses the position of the entity and
     * iterate for all GameObjects in order to check if there is a platform under it.
     *
     * @param position
     * @return boolean
     */
    public boolean hasGravity(Position position) {

        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Platform) {
                int platformX = gameObject.getPosition().getX();
                int platformY = gameObject.getPosition().getY();
                int platformWidth = gameObject.getPosition().getWidth();

                if (x < platformX + platformWidth && x + width > platformX && y < platformY && y + height + 1 >= platformY) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * If there is a Platform over the entity that call this method, it will be returned false.
     * It uses position of the entity that called it.
     *
     * @param position
     * @return boolean
     */
    public boolean canMoveUp(Position position) {

        int x = position.getX();
        int y = position.getY();
        int width = position.getWidth();

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Platform) {
                int platformX = gameObject.getPosition().getX();
                int platformY = gameObject.getPosition().getY();
                int platformWidth = gameObject.getPosition().getWidth();
                int platformHeight = gameObject.getPosition().getHeight();

                if (x < platformX + platformWidth && x + width > platformX && y <= platformY + platformHeight + 1 && y > platformY) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * If there is a Platform on the side that the entity is going to move, it will be returned false.
     * It uses position of the entity that called it and the direction that the entity will have.
     *
     * @param position
     * @param direction
     * @return boolean
     */
    public boolean canMove(Position position, Direction direction) {

        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Platform) {
                int platformX = gameObject.getPosition().getX();
                int platformY = gameObject.getPosition().getY();
                int platformHeight = gameObject.getPosition().getHeight();
                int platformWidth = gameObject.getPosition().getWidth();

                switch (direction) {
                    case RIGHT:
                        if (x < platformX + platformWidth && x + width + 1 >= platformX && y < platformY + platformHeight && y + height > platformY) {
                            return false;
                        }
                        break;

                    case LEFT:
                        if (x - 1 <= platformX + platformWidth && x + width > platformX && y < platformY + platformHeight && y + height > platformY) {
                            return false;
                        }
                        break;
                }
            }
        }

        return true;
    }


    /**
     * If there is a Ladder on the position of the entity that called it, it will be returned true.
     * It uses position of the entity that called it.
     *
     * @param position
     * @return boolean
     */
    public boolean  hasLadderCollision(Position position) {

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Ladder) {

                if (checkCollision(gameObject, position)) return true;

            }

        }

        return false;
    }


    /**
     * If there is an Enemy on the position of the entity that called it, it will be returned true.
     * It uses position of the entity that called it.
     *
     * @param position
     * @return boolean
     */
    public boolean hasEnemyCollision(Position position) {

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Enemy) {

                if (checkCollision(gameObject, position)) return true;

            }

        }

        return false;
    }


    /**
     * If there is a Key on the position of the entity that called it, it will be returned true.
     * It uses position of the entity that called it.
     *
     * @param position
     * @return GameObject
     */
    public GameObject hasKeyCollision(Position position) {

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Key) {

                if (checkCollision(gameObject, position)) return gameObject;

            }

        }

        return null;
    }


    /**
     * If there is a Cat on the position of the entity that called it, it will be returned true.
     * It uses position of the entity that called it.
     *
     * @param position
     * @return boolean
     */
    public boolean hasCatCollision(Position position) {

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Cat) {

                if (checkCollision(gameObject, position)) return true;

            }

        }

        return false;
    }


    /**
     * Private method to check collision between Objects that the Player/Enemy can be inside.
     */
    private boolean checkCollision(GameObject entity, Position position) {
        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        int entityX = entity.getPosition().getX();
        int entityY = entity.getPosition().getY();
        int entityWidth = entity.getPosition().getWidth();
        int entityHeight = entity.getPosition().getHeight();

        return x < entityX + entityWidth && x + width > entityX && y < entityY + entityHeight && y + height > entityY;
    }

}
