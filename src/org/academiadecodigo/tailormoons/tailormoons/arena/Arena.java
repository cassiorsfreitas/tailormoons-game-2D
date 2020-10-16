package org.academiadecodigo.tailormoons.tailormoons.arena;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.player.Player;

public class Arena {

    private Rectangle rectangle;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private Level level;
    private final Player player = new Player();


    public void createLevel(int levelNumber) {
        rectangle = new Rectangle(0, 0,WIDTH,HEIGHT);
        rectangle.draw();
    }


    public void play() {

        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.move();
        }
    }


    public Player getPlayer() {
        return player;
    }


    public static int getHeight() {
        return HEIGHT;
    }


    public static int getWidth() {
        return WIDTH;
    }

}
