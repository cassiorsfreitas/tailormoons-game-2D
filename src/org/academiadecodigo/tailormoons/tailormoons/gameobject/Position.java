package org.academiadecodigo.tailormoons.tailormoons.gameobject;

import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;

public class Position {

    private int x;
    private int y;
    private int width;
    private int height;

    public Position(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @param moveX
     * @param moveY
     */
    public void setCoordinates(int moveX, int moveY) {

        int nextX = x + moveX;
        int nextY = y + moveY;

        if (nextX < 0) {
            nextX = 0;
        }

        if (nextX + width > Arena.WIDTH) {
            nextX = Arena.WIDTH - width;
        }

        if (nextY < 0) {
            nextY = 0;
        }

        if (nextY + height > Arena.HEIGHT) {
            nextY = Arena.HEIGHT - height;
        }

        setX(nextX);
        setY(nextY);
    }

}
