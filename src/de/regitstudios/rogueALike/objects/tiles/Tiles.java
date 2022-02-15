/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.tiles;

import de.regitstudios.rogueALike.objects.sprites.Sprites;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public interface Tiles extends Sprites {

     Tile TILE_GRASS_01 = new Tile(SPRITE_TILE_GRASS_01, 0);
     Tile TILE_GRASS_02 = new Tile(SPRITE_TILE_GRASS_02, 1);
     Tile TILE_GRASS_03 = new Tile(SPRITE_TILE_GRASS_03, 2);
     Tile TILE_WALL_01_TOP = new Tile(SPRITE_TILE_WALL_01_TOP, 3, true);
     Tile TILE_WALL_01_RIGHT = new Tile(SPRITE_TILE_WALL_01_RIGHT, 4, true);
     Tile TILE_WALL_01_BOTTOM = new Tile(SPRITE_TILE_WALL_01_BOTTOM, 5, true);
     Tile TILE_WALL_01_LEFT = new Tile(SPRITE_TILE_WALL_01_LEFT, 6, true);
     Tile TILE_WALL_CORNER_01_TOPLEFT = new Tile(SPRITE_TILE_WALL_CORNER_01_TOPLEFT, 7, true);
     Tile TILE_WALL_CORNER_01_TOPRIGHT = new Tile(SPRITE_TILE_WALL_CORNER_01_TOPRIGHT, 8, true);
     Tile TILE_WALL_CORNER_01_BOTTOMRIGHT = new Tile(SPRITE_TILE_WALL_CORNER_01_BOTTOMRIGHT, 9, true);
     Tile TILE_WALL_CORNER_01_BOTTOMLEFT = new Tile(SPRITE_TILE_WALL_CORNER_01_BOTTOMLEFT, 10, true);
     Tile TILE_PAVERN_01 = new Tile(SPRITE_TILE_PAVERN_01, 11);
}
