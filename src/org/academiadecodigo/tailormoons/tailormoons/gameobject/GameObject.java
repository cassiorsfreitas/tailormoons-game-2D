package org.academiadecodigo.tailormoons.tailormoons.gameobject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private final Position position;
    private int maxMove;
    private int minMove;
    protected final Picture picture;

    public GameObject(int x, int y, int width, int height, String asset) {
        position = new Position(x, y, width, height);
        picture = new Picture(x, y, "assets/" + asset);
    }

    public GameObject(int x, int y, int width, int height, int minMove, int maxMove, int rightDirection, String assetRight, String assetLeft) {
        position = new Position(x, y, width, height);
        picture = new Picture(x, y, "assets/" + ((rightDirection == 1) ? assetRight : assetLeft));

        this.minMove = minMove;
        this.maxMove = maxMove;
    }


    public void show() {
        //rectangle.draw();
        picture.draw();
    }


    public void delete() {
        picture.delete();
    }


    public void draw() {
        picture.draw();
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
