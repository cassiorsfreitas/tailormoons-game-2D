package org.academiadecodigo.tailormoons.tailormoons.handler;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardListener implements KeyboardHandler {

    private Interactable entity;

    public KeyboardListener() {
        startListening();
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        entity.setKeyPressed(keyboardEvent.getKey());
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        entity.setKeyPressed(0);
    }


    public void setEntity(Interactable entity) {
        this.entity = entity;
    }


    private void startListening() {
        Keyboard keyboard = new Keyboard(this);

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


    }
}
