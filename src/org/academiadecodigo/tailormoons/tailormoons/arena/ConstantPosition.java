package org.academiadecodigo.tailormoons.tailormoons.arena;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Constant Position class stores all the initial positions of our Game Objects (Platforms, Ladders, Keys, Enemies);
 * Considerations:  Player height 75px, width 35px, max jump height 75px, max jump length 150px;
 *                  Platforms thickness 30px;
 *                  Ladder width 40px;
 *                  Keys width 30px, height 20px, float at 25px height;
 */
public class ConstantPosition {

    public static final int[] PLATFORMS_AMOUNT = {15};
    public static final int[] LADDERS_AMOUNT = {4};
    public static final int[] KEYS_AMOUNT = {6};

    public static final int[][] PLATFORMS = {{0,570,800,30}, {0,415,130,30}, {500,415,150,30}, {690,415,30,30}, {250,365,75,30},
            {375,310,120,30}, {690,265,110,30}, {0,265,200,30}, {240,140,50,30}, {0,110,130,30},
            {170,110,30,30}, {330,110,65,30}, {435,110,215,30}, {690,110,30,30}, {170,415,30,30}};

    public static final int[][] LADDERS = {{130,340,40,230}, {650, 35,40,535}, {130,35,40,230}, {395,35,40,275}};

    public static final int[][] KEYS = {{20,370,30,20}, {20,220,30,20}, {350,65,30,20}, {750,220,30,20}, {550,370,30,20},
            {750,525,30,20}};

}
