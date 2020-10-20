package org.academiadecodigo.tailormoons.tailormoons.gameobject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class GameObject {

    private final Position position;
    protected final Rectangle rectangle;
    private int maxMove;
    private int minMove;

    public GameObject(int x, int y, int width, int height) {
        position = new Position(x, y, width, height);
        rectangle = new Rectangle(x, y, width, height);
    }

    public GameObject(int x, int y, int width, int height, int minMove, int maxMove) {
        position = new Position(x, y, width, height);
        rectangle = new Rectangle(x, y, width, height);
        this.minMove = minMove;
        this.maxMove = maxMove;
    }


    public void show() {
        rectangle.draw();
    }

    public void fill() {
        rectangle.fill();
    }

    public Position getPosition() {
        return position;
    }

    public int getMaxMove() {
        return maxMove;
    }

    public int getMinMove() {
        return minMove;
    }
}
