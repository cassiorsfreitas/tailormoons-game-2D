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

        //ARENA INICIA O LEVEL
        //QUANDO AS KEYS == AO TOTAL DE KEYS DO LEVEL -> PODE TOCAR NO GATO -> ARENA INICIA O NEXT LEVEL
        //QUANDO O LEVEL ATINGIR O TOTAL DE NIVEIS -> CONGRATULATIONS!
        //SE AS LIVES DO PLAYER == 0 -> GAME OVER!


        //Starting numbers
        int totalLevels = 3;
        int level = 0;
        int keys = 0;
        int playerLives = 3;


        while (level < totalLevels + 1) {

            arena.createLevel(level);

            while (playerLives > 0) {

                while (keys < ConstantPosition.KEYS_AMOUNT[level]) {

                    arena.play(level);

                    //IF COLLIDES WITH A KEY
                    //keys++;

                    //IF COLLIDES WITH AN ENEMY
                    //lives--;

                    //IF TOUCHES CAT
                    //level++;

                }
            }
            //GAME OVER SCREEN
        }
        //YOU WON SCREEN
    }

}
