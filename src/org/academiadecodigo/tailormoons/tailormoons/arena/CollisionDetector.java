package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.tailormoons.tailormoons.direction.Direction;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Ladder;
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

                    for (int X = x; X <= x + width; X++) {

                        if (y + height + 1 == platformY && i == X) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


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

                for (int i = platformX; i < platformX + platformWidth; i++) {

                    for (int X = x; X <= x + width; X++) {

                        if (y - 1 == platformY + platformHeight && i == X) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


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

                for (int i = platformY; i < platformY + platformHeight; i++) {

                    for (int X = x; X <= x + width; X++) {

                        if (y + height + 1 == platformY && i == X) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


    public boolean hasLadderCollision(Position position) {
        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        for (GameObject gameObject : gameObjects) {

            if (gameObject instanceof Ladder) {
                int ladderX = gameObject.getPosition().getX();
                int ladderY = gameObject.getPosition().getY();
                int ladderWidth = gameObject.getPosition().getWidth();
                int ladderHeight = gameObject.getPosition().getHeight();

                for (int i = ladderY; i < ladderY + ladderHeight; i++) {

                    for (int Y = y; Y <= y + height; Y++) {
                        for (int X = x; X <= x + width; X++) {

                            if (X == ladderX + (ladderWidth / 2) && Y == i) {
                                return true;
                            }

                        }
                    }
                }
            }

        }

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
