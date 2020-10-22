package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;
import org.academiadecodigo.tailormoons.tailormoons.arena.ConstantPosition;
import org.academiadecodigo.tailormoons.tailormoons.handler.KeyboardListener;
import org.academiadecodigo.tailormoons.tailormoons.player.Player;

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
                keyboardListener.setEntity(arena.getPlayer());
                start();
            }
        }
    }


    /**
     * start() implements the logic of the game. Since the creation of the level to the game over
     *
     * @param
     */
    public void start() {

        int level = 0;

        arena.createLevel(level);
        arena.play(level);

    }

}
