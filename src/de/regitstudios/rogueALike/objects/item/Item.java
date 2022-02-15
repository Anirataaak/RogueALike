/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item;

import de.regitstudios.rogueALike.gui.GamePanel;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.objects.Sprite;

import java.awt.*;

import static de.regitstudios.rogueALike.constants.GUIConstants.TILE_SIZE;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public abstract class Item {

    private Sprite sprite;
    private String name;
    private boolean collision;
    private int worldX, worldY;
    private Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    private int solidAreaDefaultX = 0;
    private int solidAreaDefaultY = 0;

    public Item(Sprite sprite, String name, boolean collision, int worldX, int worldY) {
        setSprite(sprite);
        setName(name);
        setCollision(collision);
        setWorldX(worldX);
        setWorldY(worldY);
    }

    public void draw(Graphics2D g2, GamePanel gamePanel) {

        int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.getScreenX();
        int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.getScreenY();

        if (worldX + TILE_SIZE > gamePanel.player.getWorldX() - gamePanel.player.getScreenX() &&
            worldX - TILE_SIZE < gamePanel.player.getWorldX() + gamePanel.player.getScreenX() &&
            worldY + TILE_SIZE > gamePanel.player.getWorldY() - gamePanel.player.getScreenY() &&
            worldY - TILE_SIZE < gamePanel.player.getWorldY() + gamePanel.player.getScreenY()){

            g2.drawImage(getSprite().getSpriteImage(), screenX, screenY, TILE_SIZE, TILE_SIZE, null);
        }
    }

    public abstract void collisionEvent(Player player, GamePanel gamePanel);

    public abstract void actionEvent(Player player, GamePanel gamePanel);

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX * TILE_SIZE;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY * TILE_SIZE;
    }
}
