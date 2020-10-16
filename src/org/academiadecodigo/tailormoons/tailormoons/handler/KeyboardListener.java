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
        entity.setKey(keyboardEvent.getKey(), true);
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        entity.setKey(keyboardEvent.getKey(), false);
    }


    public void setEntity(Interactable entity) {
        this.entity = entity;
    }


    private void startListening() {
        Keyboard keyboard = new Keyboard(this);

        //PRESSED IMPLEMENTATION
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


        //RELEASE IMPLEMENTATION
        KeyboardEvent upRelease = new KeyboardEvent();
        upRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upRelease.setKey(KeyboardEvent.KEY_UP);

        keyboard.addEventListener(upRelease);

        KeyboardEvent downRelease = new KeyboardEvent();
        downRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downRelease.setKey(KeyboardEvent.KEY_DOWN);

        keyboard.addEventListener(downRelease);

        KeyboardEvent leftRelease = new KeyboardEvent();
        leftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftRelease.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(leftRelease);

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightRelease.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(rightRelease);

    }
}
