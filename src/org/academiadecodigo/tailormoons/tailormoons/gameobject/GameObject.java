package org.academiadecodigo.tailormoons.tailormoons.gameobject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class GameObject {

    protected final Position position;
    protected  Rectangle rectangle;

    public GameObject(int x, int y, int width, int height) {
        position = new Position(x, y, width, height);
        rectangle = new Rectangle(x, y, width, height);
    }


    public void show() {
        rectangle.draw();
    }

    public Position getPosition() {
        return position;
    }

}
