package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;

public class Main  {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = new Game();

        game.init();
        game.start();

    }

}
