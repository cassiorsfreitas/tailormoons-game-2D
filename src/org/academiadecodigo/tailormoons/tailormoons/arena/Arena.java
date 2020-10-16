package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.player.Player;

public class Arena {

    private final Rectangle rectangle;
    private final int height;
    private final int width;
    private Level level;
    private final Player player = new Player();

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        rectangle = new Rectangle(0, 0, width, height);
    }


    public void createLevel(int levelNumber) {
        rectangle.draw();
    }


    public void play() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.move();
        }
    }


    public Player getPlayer() {
        return player;
    }
}
