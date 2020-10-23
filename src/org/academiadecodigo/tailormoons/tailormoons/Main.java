package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;

public class Main  {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();

        while (true) {
            game.init();
            game.start();
        }

    }

}
