package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Elevator;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Platform;

/**
 * CollisionDetector detects all collisions that happens between
 */
public class CollisionDetector {

    private GameObject[] gameObjects;

    public CollisionDetector(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }


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

                for (int i = platformX; i < platformX + platformWidth; i++) {
                    if (y + height + 1 == platformY && i == x + (width / 2)) {
                        return false;
                    }
                }
            }

        }

        return true;
    }


    public boolean hasElevatorCollision(Position position) {

        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Elevator) {
                int elevatorX = gameObject.getPosition().getX();
                int elevatorY = gameObject.getPosition().getY();
                int elevatorWidth = gameObject.getPosition().getWidth();

                for (int i = elevatorX; i < elevatorX + elevatorWidth; i++) {
                    if (y + height + 1 == elevatorY && i >= x && i <= x + width) {
                        return true;
                    }
                }
            }

        }

        return false;
    }


    public boolean canJump(Position position) {

        int x = position.getX();
        int y = position.getY();
        int width = position.getWidth();

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Platform) {
                int platformX = gameObject.getPosition().getX();
                int platformY = gameObject.getPosition().getY();
                int platformWidth = gameObject.getPosition().getWidth();
                int platformHeight = gameObject.getPosition().getHeight();

                for (int i = platformX; i < platformX + platformWidth; i++) {
                    if (y - 1 == platformY + platformHeight && i == x + (width / 2)) {
                        return false;
                    }
                }
            }

        }

        return true;
    }


    public boolean canMove(Direction direction) {
        return false;
    }


    public boolean hasLadderCollision() {
        return false;
    }


    public boolean hasEnemyCollision() {
        return false;
    }


    public boolean hasKeyCollision() {
        return false;
    }


    public boolean hasCatCollision() {
        return false;
    }

}
