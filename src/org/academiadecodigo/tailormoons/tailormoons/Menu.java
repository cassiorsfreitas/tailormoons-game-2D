package org.academiadecodigo.tailormoons.tailormoons;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.tailormoons.handler.Interactable;

/**
 * Menu is a class that will display the game's welcome screen
 */
public class Menu implements Interactable {

    /**
     * The background of the Menu
     * @var background
     */
    private Picture background;

    /**
     * The blinking text
     * @var pressSpaceText
     */
    private Text pressSpaceText; //Replace with a .png image

    /**
     * A variable that saves when the space bar is pressed
     * @var spaceBar
     */
    private boolean spaceBar;

    private int keyPressed;

    /**
     * Initializes and displays all the Main Menu items
     */
    public void display() {

        background = new Picture(0, 0, "assets/menuBackground.jpg");
        background.draw();

        pressSpaceText = new Text(190, 450, "PRESS SPACE TO PUNISH YOU");
        pressSpaceText.setColor(Color.WHITE);
        pressSpaceText.draw();
    }

    /**
     * Clears all the Main Menu items
     */
    public void clearDisplay(){
        background.delete();
        pressSpaceText.delete();
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
