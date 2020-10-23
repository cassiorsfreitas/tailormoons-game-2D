package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;
import org.academiadecodigo.tailormoons.tailormoons.arena.ConstantPosition;
import org.academiadecodigo.tailormoons.tailormoons.handler.KeyboardListener;
import org.academiadecodigo.tailormoons.tailormoons.player.Player;
import org.academiadecodigo.tailormoons.tailormoons.sound.Sound;

/**
 * Game is the class delegate to process all the logic of "what a game is".
 * It will implement the score system, as well as the game over system.
 */
public class Game {

    /**
     * Instantiation of class Menu to display a Menu and wait for input from user
     *
     * @var menu
     */
    private Menu menu;

    private static final int DELAY = 5;

    /**
     * Instantiation of class Arena to display the main window of the game
     *
     * @var arena
     */
    private Arena arena;

    /**
     * KeyboardListener to handle the keyPresses and keyReleases events
     *
     * @var keyboardListener
     */
    private KeyboardListener keyboardListener;


    /**
     * init() is a method to initialize all properties
     *
     * @param
     */
    public void init() {
        keyboardListener = new KeyboardListener();
        menu = new Menu();

        keyboardListener.setEntity(menu);
        menu.display();

        while (true) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (menu.getSpaceBar()) {
                menu.clearDisplay();
                arena = new Arena();
                arena.setKeyboardListener(keyboardListener);
                return;
            }
        }
    }


    /**
     * start() implements the logic of the game. Since the creation of the level to the game over
     *
     * @param
     */
    public void start() throws InterruptedException {

        int level = 0;
        boolean hasWin = true;

        while (hasWin) {

            if (level == 4) {

                Picture winBackground = new Picture(0, 0, "assets/win.png");
                winBackground.draw();

                Sound winSound = new Sound("/assets/sounds/win.wav");
                winSound.play(true);

                Thread.sleep(3000);

                winSound.stop();

                winBackground.delete();
                return;
            }

            arena.createLevel(level);
            hasWin = arena.play(level);
            level++;

        }

        Picture loseBackground = new Picture(0, 0, "assets/gameOver.jpg");
        loseBackground.draw();

        Thread.sleep(5000);

        loseBackground.delete();

    }
}
