/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.utils;

import de.regitstudios.rogueALike.objects.tiles.Tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static de.regitstudios.rogueALike.objects.tiles.Tiles.*;
import static de.regitstudios.rogueALike.objects.tiles.Tiles.TILE_PAVERN_01;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class MapUtil {

    public static int[][] loadMap(String mapName, int mapCols, int mapRows){

        int[][] mapTileNum = new int[mapCols][mapRows];

        try {
            String MAP_FOLDER = "/Map/";
            InputStream inputStream = MapUtil.class.getResourceAsStream(MAP_FOLDER + mapName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while(col < mapCols && row < mapRows){
                String line = br.readLine();

                while(col < mapCols){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == mapCols){
                    col = 0;
                    row++;
                }
            }
            br.close();
            return mapTileNum;

        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static final List<Tile> tiles = List.of(TILE_GRASS_01, TILE_GRASS_02, TILE_GRASS_03,
            TILE_WALL_01_TOP, TILE_WALL_01_RIGHT, TILE_WALL_01_BOTTOM, TILE_WALL_01_LEFT, TILE_WALL_CORNER_01_TOPLEFT, TILE_WALL_CORNER_01_TOPRIGHT,
            TILE_WALL_CORNER_01_BOTTOMRIGHT, TILE_WALL_CORNER_01_BOTTOMLEFT, TILE_PAVERN_01);

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
