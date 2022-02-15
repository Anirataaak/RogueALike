/*  Created on 11.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.entities;

import de.regitstudios.rogueALike.gui.GamePanel;
import de.regitstudios.rogueALike.objects.Sprite;

import java.awt.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Villager extends Entity {

    public Villager(GamePanel gamePanel) {
        super(gamePanel);

        setDirection(DIR_DOWN);
        setSpeed(1);
        setEntityImage();
    }

    public void setDefaultValues() {
        super.setDefaultValues(250, 250, 1, DIR_DOWN);
    }

    @Override
    public void setEntityImage() {
        addUpAnimation(new Sprite[]{SPRITE_VILLAGER_UP_1, SPRITE_VILLAGER_UP_2});
        addDownAnimation(new Sprite[]{SPRITE_VILLAGER_DOWN_1, SPRITE_VILLAGER_DOWN_2});
        addLeftAnimation(new Sprite[]{SPRITE_VILLAGER_LEFT_1, SPRITE_VILLAGER_LEFT_2});
        addRightAnimation(new Sprite[]{SPRITE_VILLAGER_RIGHT_1, SPRITE_VILLAGER_RIGHT_2});
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g2) {
        Sprite curSprite = null;
        int screenX = getWorldX() - getGamePanel().player.getWorldX() + getGamePanel().player.getScreenX() + getWorldX();
        int screenY = getWorldY() - getGamePanel().player.getWorldY() + getGamePanel().player.getScreenY() + getWorldY();

        if (getWorldX() + TILE_SIZE > getGamePanel().player.getWorldX() - getGamePanel().player.getScreenX() &&
                getWorldX() - TILE_SIZE < getGamePanel().player.getWorldX() + getGamePanel().player.getScreenX() &&
                getWorldY() + TILE_SIZE > getGamePanel().player.getWorldY() - getGamePanel().player.getScreenY() &&
                getWorldY() - TILE_SIZE < getGamePanel().player.getWorldY() + getGamePanel().player.getScreenY());

            switch(getDirection()){
                case DIR_UP -> {
                    if(getSpriteNum() == 1){
                        curSprite = getDown(0);
                    }
                    if(getSpriteNum() == 2){
                        curSprite = getDown(1);

                }
            }
        }
        g2.drawImage(this.getDown(0).getSpriteImage(), screenX, screenY, this.getDown(0).getWidth(), this.getDown(0).getHeight(), null);
    }
}
