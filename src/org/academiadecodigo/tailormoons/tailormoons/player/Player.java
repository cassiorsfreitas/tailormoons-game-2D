package org.academiadecodigo.tailormoons.tailormoons.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.tailormoons.arena.CollisionDetector;
import org.academiadecodigo.tailormoons.tailormoons.arena.Movable;
import org.academiadecodigo.tailormoons.tailormoons.handler.Interactable;

public class Player implements Movable, Interactable {

    //Change to picture
    private final Rectangle rectangle;
    private CollisionDetector collisionDetector;
    private final int gravity = 200;
    private final int speed = 10;

    public Player() {
        rectangle = new Rectangle(400, 500, 35, 100);
        rectangle.setColor(Color.MAGENTA);

        startListening();
    }


    private void startListening() {
        /*
        Keyboard keyboard = new Keyboard(keyboardListener);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        keyboard.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(right);

         */

    }


    public void display() {
        rectangle.draw();
    }


    @Override
    public void move() {

    }


    @Override
    public void setKeyPressed() {

    }
    
}
