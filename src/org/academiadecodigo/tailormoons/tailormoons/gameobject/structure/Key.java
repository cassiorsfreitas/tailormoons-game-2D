package org.academiadecodigo.tailormoons.tailormoons.gameobject.structure;

import org.academiadecodigo.tailormoons.tailormoons.gameobject.GameObject;

public class Key extends GameObject {

    private boolean taken;

    public Key(int x, int y, int width, int height) {
        super(x, y, width, height, "key.png");
    }


    public boolean getTaken() {
        return taken;
    }


    public void setTaken() {
        taken = true;
    }
}
