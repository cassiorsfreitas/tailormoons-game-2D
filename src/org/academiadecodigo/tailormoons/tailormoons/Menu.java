package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.handler.Interactable;
import org.academiadecodigo.tailormoons.tailormoons.sound.Sound;

/**
 * Menu is a class that will display the game's welcome screen
 */
public class Menu implements Interactable {

    /**
     * The background of the Menu
     * @var background
     */
    private Picture background;

    private Sound sound;

    /**
     * A variable that saves when the space bar is pressed
     * @var spaceBar
     */
    private boolean spaceBar;

    /**
     * Initializes and displays all the Main Menu items
     */
    public void display() {
        background = new Picture(0, 0, "assets/menuBackground.jpg");
        background.draw();

        sound = new Sound("/assets/menu.wav");
        sound.play(true);
    }

    /**
     * Clears all the Main Menu items
     */
    public void clearDisplay(){
        background.delete();
        sound.stop();
    }

    @Override
    public void setKey(int key, boolean state) {
        if (key == KeyboardEvent.KEY_SPACE) {
            spaceBar = state;
        }
    }

    public boolean getSpaceBar(){
        return spaceBar;
    }
}
