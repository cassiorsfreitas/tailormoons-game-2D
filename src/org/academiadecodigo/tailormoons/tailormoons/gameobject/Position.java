package org.academiadecodigo.tailormoons.tailormoons.gameobject;

import org.academiadecodigo.tailormoons.tailormoons.arena.Arena;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void setCoordinates(int moveX, int moveY, int width, int height) {

        int nextX = x + moveX;
        int nextY = y + moveY;

        if (nextX < 0) {
            nextX = 0;
        }

        if (nextX + width > Arena.getWidth()) {
            nextX = Arena.getWidth() - width;
        }

        if (nextY < 0) {
            nextY = 0;
        }

        if (nextY + height > Arena.getHeight()) {
            nextY = Arena.getHeight() - height;
        }

        setX(nextX);
        setY(nextY);
    }


    private void setX(int x) {
        this.x = x;
    }


    private void setY(int y) {
        this.y = y;
    }

}
