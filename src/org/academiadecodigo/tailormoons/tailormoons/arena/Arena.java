package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.enemy.Enemy;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.structure.Key;
import org.academiadecodigo.tailormoons.tailormoons.handler.KeyboardListener;
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
    private Player player;

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
    private int lives = 5;

    private final Picture[] livesHeads = new Picture[lives];

    /**
     * Constant delay that will be the speed of the game flux.
     *
     * @var DELAY
     */
    private static final int DELAY = 5;

    /**
     *
     */
    private KeyboardListener keyboardListener;


    public Arena() {

        rectangle = new Rectangle(0, 0, WIDTH, HEIGHT);
        rectangle.draw();


    }

    /**
     * Method delegate to create the field, GameObjects, collisionDetector as well as give their reference to enemy/player
     *
     * @param levelNumber
     */
    public void createLevel(int levelNumber) {

        level = new Level(levelNumber);
        level.getBackground().draw();
        level.createEntities();

        sound = new Sound("/assets/sounds/inGame.wav");
        sound.setLoop(50);
        sound.play(true);

        initPlayer(levelNumber);

        for (GameObject gameObject : level.getGameObjects()) {
            if (gameObject instanceof Enemy) {
                ((Enemy) gameObject).setCollisionDetector(new CollisionDetector(level.getGameObjects()));
            }
        }

        drawLives();
    }


    /**
     * For each iteration, with a delay of 'delay', Arena is going to move all entities.
     */
    public boolean play(int levelNumber) throws InterruptedException {

        while (true) {

            Thread.sleep(DELAY);

            player.move();
            for (GameObject object : level.getGameObjects()) {
                if (object instanceof Movable) {
                    ((Movable) object).move();
                }
            }


            if (player.isDead()) {

                lives--;
                livesHeads[lives].delete();

                Sound loseLiveSound = new Sound("/assets/sounds/die.wav");
                loseLiveSound.play(true);

                Thread.sleep(2000);

                loseLiveSound.close();

                if (lives == 0) {
                    sound.close();
                    return false;
                }


                player.die();
                initPlayer(levelNumber);

            }


            GameObject key = player.getKeyTaken();
            if (key != null) {

                if (!((Key) key).getTaken()) {
                    Sound keyTakenSound = new Sound("/assets/sounds/ping.wav");
                    //keyTakenSound.play(true);
                }

                level.deleteKey(key);
                player.resetKeyTaken();
            }


            if (player.getIsOverCat()) {
                if (level.isWinnable()) {

                    sound.close();

                    Picture cat = new Picture(ConstantPosition.CAT_CAGES[levelNumber][0] + 22, ConstantPosition.CAT_CAGES[levelNumber][1] + 44, "assets/cat.png");
                    cat.draw();

                    Sound catReleaseSound = new Sound("/assets/sounds/levelUp.wav");
                    catReleaseSound.play(true);

                    Thread.sleep(2000);

                    catReleaseSound.stop();

                    cat.delete();
                    return true;

                }
            }
        }
    }


    public void initPlayer(int levelNumber) {
        player = new Player(ConstantPosition.PLAYER_POSITION[levelNumber][0], ConstantPosition.PLAYER_POSITION[levelNumber][1]);
        player.display();
        keyboardListener.setEntity(player);
        player.setCollisionDetector(new CollisionDetector(level.getGameObjects()));
    }


    /**
     * Return a player
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }


    public void setKeyboardListener(KeyboardListener keyboardListener) {
        this.keyboardListener = keyboardListener;
    }


    public void drawLives() {
        for (int i = 0; i < lives; i++) {
            livesHeads[i] = new Picture(342 + (i * 25), 10, "assets/life.png");
            livesHeads[i].draw();
        }
    }

}
