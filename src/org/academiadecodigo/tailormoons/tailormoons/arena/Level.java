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
    private LinkedList<GameObject> gameObjects = new LinkedList<>();


    public Level(int levelNumber) {
        Picture background = new Picture(0, 0, "assets/background-level-1.jpg");
        background.draw();

        createEntities(levelNumber);
    }


    private void createEntities(int level) {

        for (int i = 0; i < ConstantPosition.PLATFORMS_AMOUNT[level]; i++) {
            int x = ConstantPosition.PLATFORMS[level][i][0];
            int y = ConstantPosition.PLATFORMS[level][i][1];
            int width = ConstantPosition.PLATFORMS[level][i][2];
            int height = ConstantPosition.PLATFORMS[level][i][3];

            int platformDivisions = width / ConstantPosition.PLATFORM_WIDTH;
            for (int j = 0; j < platformDivisions; j++) {
                gameObjects.add(new Platform(x + j * ConstantPosition.PLATFORM_WIDTH, y, ConstantPosition.PLATFORM_WIDTH, height));
                gameObjects.getLast().show();
            }
            if (width % ConstantPosition.PLATFORM_WIDTH != 0) {
                gameObjects.add(new Platform(x + width - ConstantPosition.PLATFORM_WIDTH, y, ConstantPosition.PLATFORM_WIDTH, height));
                gameObjects.getLast().show();
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
                gameObjects.getLast().show();
            }
            if (height % ConstantPosition.LADDER_HEIGHT != 0) {
                gameObjects.add(new Ladder(x, y + height - ConstantPosition.LADDER_HEIGHT, width, ConstantPosition.LADDER_HEIGHT));
                gameObjects.getLast().show();
            }
        }

        for (int i = 0; i < ConstantPosition.KEYS_AMOUNT[level]; i++) {
            int x = ConstantPosition.KEYS[level][i][0];
            int y = ConstantPosition.KEYS[level][i][1];
            int width = ConstantPosition.KEYS[level][i][2];
            int height = ConstantPosition.KEYS[level][i][3];

            gameObjects.add(new Key(x, y, width, height));
            gameObjects.getLast().show();
        }

        gameObjects.add(new Cat(ConstantPosition.CAT_CAGES[level][0], ConstantPosition.CAT_CAGES[level][1], ConstantPosition.CAT_CAGES[level][2], ConstantPosition.CAT_CAGES[level][3]));
        gameObjects.getLast().show();

        //TEMPORARY ENEMY
        //gameObjects[2] = new Sid();
        for (int i = 0; i < ConstantPosition.ENEMIES_AMOUNT[level]; i++) {
            int x = ConstantPosition.ENEMIES[i][0];
            int y = ConstantPosition.ENEMIES[i][1];
            int width = ConstantPosition.ENEMIES[i][2];
            int height = ConstantPosition.ENEMIES[i][3];
            int minMove = ConstantPosition.ENEMIES[i][4];
            int maxMove = ConstantPosition.ENEMIES[i][5];
            if (i == 0) {
                gameObjects.add(new Sid(x, y, width, height, minMove, maxMove));
                gameObjects.getLast().draw();
            }
            if (i == 1) {
                gameObjects.add(new Francisco(x, y, width, height, minMove, maxMove));
                gameObjects.getLast().draw();
            }
            if (i == 2) {
                gameObjects.add(new Vando(x, y, width, height, minMove, maxMove));
                gameObjects.getLast().draw();
            }
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
        for(GameObject entity : gameObjects) {
            if(entity instanceof Key) {
                if (!((Key) entity).getTaken()) {
                    return false;
                }
            }
        }
        return true;
    }

}
