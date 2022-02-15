/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects;

import de.regitstudios.rogueALike.gui.GamePanel;
import de.regitstudios.rogueALike.objects.item.Item;

import java.awt.*;
import java.util.ArrayList;

import static de.regitstudios.rogueALike.constants.GUIConstants.TILE_SIZE;
import static de.regitstudios.rogueALike.handler.MapHandler.loadMap;
import static de.regitstudios.rogueALike.handler.TileHandler.getTileByIndex;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Map {

    private String mapName;
    private int[][] mapRowCol;
    private ArrayList<Item> items;
    private int mapCols;
    private int mapRows;

    public Map(String mapName, ArrayList<Item> items, int mapCols, int mapRows){
        setMapName(mapName);
        setMapCols(mapCols);
        setMapRows(mapRows);
        setMapRowCol(loadMap(getMapName(), getMapCols(), getMapRows()));
        setItems(items);
    }

    public void draw(Graphics2D graphics, GamePanel gamePanel){

        int mapCol = 0;
        int mapRow = 0;

        while(mapCol < getMapCols() && mapRow < getMapRows()){

            int tileNum = getMapRowCol()[mapCol][mapRow];
            Tile curTile = getTileByIndex(tileNum);

            int worldX = mapCol * TILE_SIZE;
            int worldY = mapRow * TILE_SIZE;
            int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.getScreenX();
            int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.getScreenY();

            //Sorgt dafür, dass nur die Tiles in der direkt Umgebung des Spielers geladen werden
            if(worldX + TILE_SIZE > gamePanel.player.getWorldX() - gamePanel.player.getScreenX() &&
                    worldX - TILE_SIZE < gamePanel.player.getWorldX() + gamePanel.player.getScreenX() &&
                    worldY + TILE_SIZE > gamePanel.player.getWorldY() - gamePanel.player.getScreenY() &&
                    worldY - TILE_SIZE < gamePanel.player.getWorldY() + gamePanel.player.getScreenY()){
                graphics.drawImage(curTile.getSprite().getSpriteImage(), screenX, screenY, curTile.getSprite().getWidth(), curTile.getSprite().getWidth(), null);

            }

            mapCol++;

            if(mapCol == getMapCols()){
                mapCol = 0;
                mapRow++;
            }
        }
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getMapCols() {
        return mapCols;
    }

    public void setMapCols(int mapCols) {
        this.mapCols = mapCols;
    }

    public int getMapRows() {
        return mapRows;
    }

    public void setMapRows(int mapRows) {
        this.mapRows = mapRows;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int[][] getMapRowCol() {
        return mapRowCol;
    }

    public void setMapRowCol(int[][] mapRowCol) {
        this.mapRowCol = mapRowCol;
    }
}
