/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.handler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class MapHandler {

    public static int[][] loadMap(String mapName, int mapCols, int mapRows){

        int[][] mapTileNum = new int[mapCols][mapRows];

        try {
            String MAP_FOLDER = "/Map/";
            InputStream inputStream = MapHandler.class.getResourceAsStream(MAP_FOLDER + mapName);
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
}
