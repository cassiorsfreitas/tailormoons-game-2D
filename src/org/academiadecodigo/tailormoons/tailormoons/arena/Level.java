package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.cat.Cat;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Francisco;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Sid;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Vando;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Key;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Ladder;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Platform;

import java.util.LinkedList;

/**
 * Level is a class where entities of GameObjects are going to be created.
 * It is responsible to generate the level that is being played by the Player.
 */
public class Level {

    /**
     *
     */
    private final LinkedList<GameObject> gameObjects = new LinkedList<>();

    private final Picture background;

    private int level;


    public Level(int level) {
        background = new Picture(0, 0, "assets/background-level-1.jpg");

        this.level = level;

    }


    public void createEntities() {

        for (int i = 0; i < ConstantPosition.PLATFORMS_AMOUNT[level]; i++) {
            int x = ConstantPosition.PLATFORMS[level][i][0];
            int y = ConstantPosition.PLATFORMS[level][i][1];
            int width = ConstantPosition.PLATFORMS[level][i][2];
            int height = ConstantPosition.PLATFORMS[level][i][3];

            int platformDivisions = width / ConstantPosition.PLATFORM_WIDTH;
            for (int j = 0; j < platformDivisions; j++) {
                gameObjects.add(new Platform(x + j * ConstantPosition.PLATFORM_WIDTH, y, ConstantPosition.PLATFORM_WIDTH, height));
            }
            if (width % ConstantPosition.PLATFORM_WIDTH != 0) {
                gameObjects.add(new Platform(x + width - ConstantPosition.PLATFORM_WIDTH, y, ConstantPosition.PLATFORM_WIDTH, height));
            }
        }

        for (int i = 0; i < ConstantPosition.LADDERS_AMOUNT[level]; i++) {
            int x = ConstantPosition.LADDERS[level][i][0];
            int y = ConstantPosition.LADDERS[level][i][1];
            int width = ConstantPosition.LADDERS[level][i][2];
            int height = ConstantPosition.LADDERS[level][i][3];

            int ladderDivisions = height / ConstantPosition.LADDER_HEIGHT;
            for (int j = 0; j < ladderDivisions; j++) {
                gameObjects.add(new Ladder(x, y + j * ConstantPosition.LADDER_HEIGHT, width, ConstantPosition.LADDER_HEIGHT));
            }
            if (height % ConstantPosition.LADDER_HEIGHT != 0) {
                gameObjects.add(new Ladder(x, y + height - ConstantPosition.LADDER_HEIGHT, width, ConstantPosition.LADDER_HEIGHT));
            }
        }

        for (int i = 0; i < ConstantPosition.KEYS_AMOUNT[level]; i++) {
            int x = ConstantPosition.KEYS[level][i][0];
            int y = ConstantPosition.KEYS[level][i][1];
            int width = ConstantPosition.KEYS[level][i][2];
            int height = ConstantPosition.KEYS[level][i][3];

            gameObjects.add(new Key(x, y, width, height));
        }

        gameObjects.add(new Cat(ConstantPosition.CAT_CAGES[level][0], ConstantPosition.CAT_CAGES[level][1], ConstantPosition.CAT_CAGES[level][2], ConstantPosition.CAT_CAGES[level][3]));


        for (int i = 0; i < ConstantPosition.ENEMIES_AMOUNT[level]; i++) {
            int x = ConstantPosition.ENEMIES[level][i][0];
            int y = ConstantPosition.ENEMIES[level][i][1];
            int width = ConstantPosition.ENEMIES[level][i][2];
            int height = ConstantPosition.ENEMIES[level][i][3];
            int minMove = ConstantPosition.ENEMIES[level][i][4];
            int maxMove = ConstantPosition.ENEMIES[level][i][5];
            if (i == 0 || i == 3) {
                gameObjects.add(new Sid(x, y, width, height, minMove, maxMove));
            }
            if (i == 1 || i == 4) {
                gameObjects.add(new Francisco(x, y, width, height, minMove, maxMove));
            }
            if (i == 2 || i == 5 || i == 6) {
                gameObjects.add(new Vando(x, y, width, height, minMove, maxMove));
            }
        }

        /**
         * DRAW
         */
        for (GameObject object : gameObjects) {
            object.draw();
        }
    }


    public LinkedList<GameObject> getGameObjects() {
        return gameObjects;
    }


    public void deleteKey(GameObject key) {
        ((Key) key).setTaken();
        key.delete();
    }


    public boolean isWinnable() {
        for (GameObject entity : gameObjects) {
            if (entity instanceof Key) {
                if (!((Key) entity).getTaken()) {
                    return false;
                }
            }
        }
        return true;
    }


    public Picture getBackground() {
        return background;
    }

}
