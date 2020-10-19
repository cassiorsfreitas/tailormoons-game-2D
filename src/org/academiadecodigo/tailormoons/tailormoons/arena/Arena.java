package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.player.Player;

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
    private Level level = new Level();

    /**
     * A reference to the player that will be moving
     *
     * @var player
     */
    private final Player player = new Player();

    private static final int DELAY = 5;

    /**
     * A reference to the collisionDetector that will be used to check collisions with GameObjects
     * @var collisionDetector
     */
    //private CollisionDetector collisionDetector;


    /**
     * Method delegate to create the field, GameObjects, collisionDetector as well as give their reference to enemy/player
     *
     * @param levelNumber
     */
    public void createLevel(int levelNumber) {
        rectangle = new Rectangle(0, 0, WIDTH, HEIGHT);
        rectangle.draw();

        level.createEntities(1);

        //collisionDetector = new CollisionDetector(level.getGameObjects());
        player.setCollisionDetector(new CollisionDetector(level.getGameObjects()));
        //Verificar com todos
        for (GameObject gameObject : level.getGameObjects()) {
            if (gameObject instanceof Enemy) {
                ((Enemy) gameObject).setCollisionDetector(new CollisionDetector(level.getGameObjects()));
            }
        }
    }


    /**
     * For each iteration, with a delay of 'delay', Arena is going to move all entities.
     */
    public void play() {

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
