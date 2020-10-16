package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;
import org.academiadecodigo.tailormoons.tailormoons.handler.KeyboardListener;

public class Game {

    private Menu menu;
    private Arena arena;
    private KeyboardListener keyboardListener;


    public void init() {
        menu = new Menu();
        arena = new Arena(800, 600);
        keyboardListener = new KeyboardListener();
        keyboardListener.setEntity(arena.getPlayer());
    }


    public void start() {
        arena.createLevel(1);
        arena.play();
    }

}
