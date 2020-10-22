package org.academiadecodigo.tailormoons.tailormoons.gameobject.structure;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;
import org.academiadecodigo.tailormoons.tailormoons.gameobject.Position;

public class Elevator extends GameObject implements Movable {


    public Elevator(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move() {

        int initialX = this.getPosition().getX();
        int initialY = this.getPosition().getY();
        int moveY = -1;

        this.getPosition().setCoordinates(0, moveY);
        rectangle.translate(0, moveY);

        if (this.getPosition().getY() == 0) {
            //getPosition().
            rectangle.setColor(Color.RED);
            //this.getPosition().setCoordinates();
        }

        System.out.println(this.getPosition().getX());
        System.out.println(this.getPosition().getY());

    }
}
