package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.player.Player;
import org.academiadecodigo.tailormoons.tailormoons.sound.Sound;

/**
 * Arena is the class that will work as field of the game window. It will also have
 * the background picture for the game.
 * Arena is, as well, the class delegated to ask a level creation and a player creation.
 */
public class Arena {

    /**
     * The field of the game
     *
     * @var rectangle
     */
    private Rectangle rectangle;

    /**
     * Variables HEIGHT and WIDTH defines the dimensions of the window
     *
     * @vars HEIGHT, WIDTH
     */
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;

    /**
     * Arena HAS-A Level, that must be instantiated.
     * Level has all the logic to dispose the GameObjects
     *
     * @var level
     */
    private Level level;

    /**
     * A reference to the player that will be moving
     *
     * @var player
     */
    private Player player = new Player();

    /**
     * A reference to the in game song
     *
     * @var player
     */
    private Sound sound;

    /**
     * Number of lives from the begging of the game until the end.
     *
     * @var lives
     */
    private int lives = 3;

    /**
     * Constant delay that will be the speed of the game flux.
     *
     * @var DELAY
     */
    private static final int DELAY = 5;

    /**
     * A reference to the collisionDetector that will be used to check collisions with GameObjects
     *
     * @var collisionDetector
     */
    private CollisionDetector collisionDetector;


    /**
     * Method delegate to create the field, GameObjects, collisionDetector as well as give their reference to enemy/player
     *
     * @param levelNumber
     */
    public void createLevel(int levelNumber) {
        rectangle = new Rectangle(0, 0, WIDTH, HEIGHT);
        rectangle.draw();

        level = new Level(levelNumber);

        player.display();

        sound = new Sound("/assets/sounds/inGame.wav");
        sound.play(true);

        player.setCollisionDetector(new CollisionDetector(level.getGameObjects()));
        for (GameObject gameObject : level.getGameObjects()) {
            if (gameObject instanceof Enemy) {
                ((Enemy) gameObject).setCollisionDetector(new CollisionDetector(level.getGameObjects()));
            }
        }
    }


    /**
     * For each iteration, with a delay of 'delay', Arena is going to move all entities.
     */
    public void play(int levelNumber) {

        while (true) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.move();
            for (GameObject object : level.getGameObjects()) {
                if (object instanceof Movable) {
                    ((Movable) object).move();
                }
            }

            if (player.isDead()) {
                lives--;
                if (lives == 0) {
                    //RETURNAR PARA O GAME PK ACABOU GAME FUCKING OVER
                }
            }

            GameObject key = player.getKeyTaken();
            if (key != null) {
                level.deleteKey(key);
                player.resetKeyTaken();
            }

            if(player.getIsOverCat()) {
                if (level.isWinnable()) {
                    System.out.println("YOU FUCKING WIN");
                }
            }

        }
    }


    /**
     * Return a player
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

}
