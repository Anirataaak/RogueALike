/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.handler;

import de.regitstudios.rogueALike.constants.GUIConstants;
import de.regitstudios.rogueALike.gui.GamePanel;
import de.regitstudios.rogueALike.objects.entities.Entity;
import de.regitstudios.rogueALike.objects.item.Item;

import java.util.ArrayList;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class CollisionHandler implements GUIConstants {

    private final GamePanel gamePanel;

    public CollisionHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTileForCollision(Entity entity) {
        int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
        int entityRightWorldX = entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;
        int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
        int entityBottomWorldY = entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;

        int entityLeftCol = entityLeftWorldX / TILE_SIZE;
        int entityRightCol = entityRightWorldX / TILE_SIZE;
        int entityTopRow = entityTopWorldY / TILE_SIZE;
        int entityBottomRow = entityBottomWorldY / TILE_SIZE;

        int tileNum1, tileNum2;

        switch (entity.getDirection()) {
            case GUIConstants.DIR_UP -> {
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / TILE_SIZE;
                tileNum1 = gamePanel.getCurrentMap().getMapRowCol()[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.getCurrentMap().getMapRowCol()[entityRightCol][entityTopRow];
                if (TileHandler.getTileByIndex(tileNum1).isCollision() || TileHandler.getTileByIndex(tileNum2).isCollision()) {
                    entity.setCollisionOn(true);
                }
            }
            case GUIConstants.DIR_DOWN -> {
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / TILE_SIZE;
                tileNum1 = gamePanel.getCurrentMap().getMapRowCol()[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.getCurrentMap().getMapRowCol()[entityRightCol][entityBottomRow];
                if (TileHandler.getTileByIndex(tileNum1).isCollision() || TileHandler.getTileByIndex(tileNum2).isCollision()) {
                    entity.setCollisionOn(true);
                }
            }
            case GUIConstants.DIR_LEFT -> {
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / TILE_SIZE;
                tileNum1 = gamePanel.getCurrentMap().getMapRowCol()[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.getCurrentMap().getMapRowCol()[entityLeftCol][entityBottomRow];
                if (TileHandler.getTileByIndex(tileNum1).isCollision() || TileHandler.getTileByIndex(tileNum2).isCollision()) {
                    entity.setCollisionOn(true);
                }
            }
            case GUIConstants.DIR_RIGHT -> {
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / TILE_SIZE;
                tileNum1 = gamePanel.getCurrentMap().getMapRowCol()[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.getCurrentMap().getMapRowCol()[entityRightCol][entityBottomRow];
                if (TileHandler.getTileByIndex(tileNum1).isCollision() || TileHandler.getTileByIndex(tileNum2).isCollision()) {
                    entity.setCollisionOn(true);
                }
            }
        }
    }

    public Item checkObjectCollision(Entity entity, boolean player) {

        Item returnItem = null;
        ArrayList<Item> items = gamePanel.getCurrentMap().getItems();

        for (Item item : gamePanel.getCurrentMap().getItems()) {

            if (item != null) {

                entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;

                item.getSolidArea().x = item.getWorldX() + item.getSolidArea().x;
                item.getSolidArea().y = item.getWorldY() + item.getSolidArea().y;

                switch (entity.getDirection()) {
                    case DIR_UP -> {
                        entity.getSolidArea().y -= entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if(item.isCollision()){
                                entity.setCollisionOn(true);
                            }
                            if(player){
                                returnItem = item;
                            }
                        }
                    }
                    case DIR_DOWN -> {
                        entity.getSolidArea().y += entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if(item.isCollision()){
                                entity.setCollisionOn(true);
                            }
                            if(player){
                                returnItem = item;
                            }
                        }
                    }
                    case DIR_LEFT -> {
                        entity.getSolidArea().x -= entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if(item.isCollision()){
                                entity.setCollisionOn(true);
                            }
                            if(player){
                                returnItem = item;
                            }
                        }
                    }
                    case DIR_RIGHT -> {
                        entity.getSolidArea().x += entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if(item.isCollision()){
                                entity.setCollisionOn(true);
                            }
                            if(player){
                                returnItem = item;
                            }
                        }
                    }
                }
                entity.getSolidArea().x = entity.getSolidAreaDefaultX();
                entity.getSolidArea().y = entity.getSolidAreaDefaultY();
                item.getSolidArea().x = item.getSolidAreaDefaultX();
                item.getSolidArea().y = item.getSolidAreaDefaultY();
            }
        }
        return returnItem;
    }
}
