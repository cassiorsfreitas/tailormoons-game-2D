package org.academiadecodigo.tailormoons.tailormoons.arena;


/**
 * Constant Position class stores all the initial positions of our Game Objects (Platforms, Ladders, Keys, Enemies);
 * Considerations:  Player height 50px, width 35px, max jump height 75px, max jump length 150px;
 * Platforms thickness 20px, distance between platforms 125px (player height + jump height)
 * Ladder width 40px;
 * Keys width 30px, height 20px, float at 25px height;
 */
public class ConstantPosition {

    public static final int PLATFORM_HEIGHT = 20;
    public static final int LADDER_WIDTH = 40;
    public static final int KEY_WIDTH = 30;
    public static final int KEY_HEIGHT = 30;
    public static final int CAGE_WIDTH = 100;
    public static final int CAGE_HEIGHT = 100;

    public static final int PLATFORM_WIDTH = 30;
    public static final int LADDER_HEIGHT = 15;

    public static final int[] PLATFORMS_AMOUNT = {15, 2};
    public static final int[] LADDERS_AMOUNT = {4, 2};
    public static final int[] KEYS_AMOUNT = {6, 2};

    public static final int[] ENEMIES_AMOUNT = {3};
    public static final int[][][] PLATFORMS = {
            //LEVEL 1
            {
                    {0, 580, 800, PLATFORM_HEIGHT}, {0, 425, 130, PLATFORM_HEIGHT}, {500, 425, 150, PLATFORM_HEIGHT},
                    {690, 425, 30, PLATFORM_HEIGHT}, {250, 375, 75, PLATFORM_HEIGHT}, {375, 320, 120, PLATFORM_HEIGHT},
                    {690, 275, 110, PLATFORM_HEIGHT}, {0, 275, 200, PLATFORM_HEIGHT}, {240, 150, 50, PLATFORM_HEIGHT},
                    {0, 120, 130, PLATFORM_HEIGHT}, {170, 120, 30, PLATFORM_HEIGHT}, {330, 120, 65, PLATFORM_HEIGHT},
                    {435, 120, 215, PLATFORM_HEIGHT}, {690, 120, 30, PLATFORM_HEIGHT}, {170, 425, 30, PLATFORM_HEIGHT}
            },

            //LEVEL 2
            {
                    {0, 580, 800, PLATFORM_HEIGHT}, {0, 425, 130, PLATFORM_HEIGHT}}


    };

    public static final int[][][] LADDERS = {
            //LEVEL1
            {
                    {130, 375, LADDER_WIDTH, 205}, {650, 70, LADDER_WIDTH, 510}, {130, 70, LADDER_WIDTH, 205},
                    {395, 70, LADDER_WIDTH, 250}
            },
            //LEVEL 2
            {
                    {130, 375, LADDER_WIDTH, 205}, {650, 70, LADDER_WIDTH, 510}}
    };

    public static final int[][][] KEYS = {
            //LEVEL1
            {
                    {20, 370, KEY_WIDTH, KEY_HEIGHT}, {20, 220, KEY_WIDTH, KEY_HEIGHT}, {350, 65, KEY_WIDTH, KEY_HEIGHT},
                    {750, 220, KEY_WIDTH, KEY_HEIGHT}, {550, 370, KEY_WIDTH, KEY_HEIGHT}, {750, 525, KEY_WIDTH, KEY_HEIGHT}
            },
            //LEVEL 2
            {
                    {20, 370, KEY_WIDTH, KEY_HEIGHT}, {20, 220, KEY_WIDTH, KEY_HEIGHT}
            }
    };

    public static final int[][] CAT_CAGES = {
            //LEVEL1

            {10, 20, CAGE_WIDTH, CAGE_HEIGHT},

            //LEVEL 2

            {40, 20, CAGE_WIDTH, CAGE_HEIGHT}

    };


    private static final int width = 35;
    private static final int height = 45;
    public static final int[][] ENEMIES = {{325, 82, width, height, 325, 698},
            {350, 542, width, height, 0, 765},
            {500, 387, width, height, 500, 685}};
}
