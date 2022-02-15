/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.handler;

import de.regitstudios.rogueALike.objects.Tile;

import java.util.ArrayList;
import java.util.Arrays;

import static de.regitstudios.rogueALike.constants.Tiles.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class TileHandler {

    private static final ArrayList<Tile> tiles = new ArrayList<>(Arrays.asList(TILE_GRASS_01, TILE_GRASS_02, TILE_GRASS_03,
            TILE_WALL_01_TOP, TILE_WALL_01_RIGHT, TILE_WALL_01_BOTTOM, TILE_WALL_01_LEFT, TILE_WALL_CORNER_01_TOPLEFT, TILE_WALL_CORNER_01_TOPRIGHT,
            TILE_WALL_CORNER_01_BOTTOMRIGHT, TILE_WALL_CORNER_01_BOTTOMLEFT, TILE_PAVERN_01));

    public static Tile getTileByIndex(int index){
        Tile tile = null;
        for(Tile curTile : tiles){
            if(curTile.getIndex() == index){
                tile = curTile;
            }
        }
        return tile;
    }
}
