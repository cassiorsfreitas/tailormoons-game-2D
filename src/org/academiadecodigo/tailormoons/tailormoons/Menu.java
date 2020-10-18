package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.handler.Interactable;

public class Menu implements Interactable {

    private int keyPressed;

    public void display() {

        Picture menuBackground = new Picture(10, 10, "assets/menuBackground.jpg");
        menuBackground.draw();

        //Change this text for a .png image
        Text startGame = new Text(190, 450, "PRESS SPACE TO PUNISH YOU");
        startGame.setColor(Color.WHITE);
        startGame.draw();
    }


    @Override
    public void setKey(int key, boolean state) {
        if (key == KeyboardEvent.KEY_SPACE) {
            keyPressed = 1;
        }
    }

    public int getKeyPressed() {
        return keyPressed;
    }
}
