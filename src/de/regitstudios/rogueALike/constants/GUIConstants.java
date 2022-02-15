/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.constants;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public interface GUIConstants {

    //Game Window Constants
    String GAME_TITLE = "Heyjo its a rogue a like game";

    //Game Panel Constants
    int ORIGINAL_TITLE_SIZE = 16;
    int SCALE = 3;
    int TILE_SIZE = ORIGINAL_TITLE_SIZE * SCALE;
    int SCREEN_COLS = 16;
    int SCREEN_ROWS = 12;
    int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS;
    int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS;
    int FPS = 60;
    int WORLD_COLS = 50;
    int WORLD_ROWS = 50;
    int WORLD_WIDTH = TILE_SIZE * WORLD_COLS;
    int WORLD_HEIGHT = TILE_SIZE * WORLD_ROWS;

    //Entity Constants
    String DIR_UP = "UP";
    String DIR_DOWN = "DOWN";
    String DIR_LEFT = "LEFT";
    String DIR_RIGHT = "RIGHT";
    
    String TEST = "TEST";
    String TEST1 = "TEST1";
    String TEST2 = "TEST2";
    String TEST3 = "TEST3";
    String TEST5 = "TEST5";
    String TEST4 = "TEST4";
}
