package org.academiadecodigo.tailormoons.tailormoons.gameobject.structure;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;

public class Elevator extends GameObject implements Movable {

    public Elevator(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move() {

        int moveY = -1;

        position.setY(position.getY() + moveY);
        rectangle.translate(0, moveY);

        if (position.getY() <= -100) {
            position.setY(590);
            rectangle = new Rectangle(position.getX(), position.getY(), position.getWidth(), position.getHeight());
            rectangle.draw();
        }

        //System.out.println(position.getY());

    }
}
