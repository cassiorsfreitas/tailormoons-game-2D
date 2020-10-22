package org.academiadecodigo.tailormoons.tailormoons.gameobject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private final Position position;
    private final Picture picture;

    public GameObject(int x, int y, int width, int height, String asset) {
        position = new Position(x, y, width, height);
        picture = new Picture(x, y, asset);
    }


    public void show() {
        //rectangle.draw();
        picture.draw();
    }


    public void delete() {
        picture.delete();
    }


    public Position getPosition() {
        return position;
    }
}
