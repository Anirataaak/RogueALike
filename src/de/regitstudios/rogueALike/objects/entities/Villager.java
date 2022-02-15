/*  Created on 11.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.entities;

import de.regitstudios.rogueALike.gui.interfaces.InGameInterface;
import de.regitstudios.rogueALike.objects.sprites.Sprite;

import java.awt.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Villager extends Entity {

    public Villager(InGameInterface gamePanel) {
        super(gamePanel);

        setDirection(DIR_DOWN);
        setSpeed(1);
        setEntityImage();
        setDefaultValues();
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

        int screenX = getWorldX() - getGamePanel().getCurrentPlayer().getWorldX() + getGamePanel().getCurrentPlayer().getScreenX();
        int screenY = getWorldY() - getGamePanel().getCurrentPlayer().getWorldY() + getGamePanel().getCurrentPlayer().getScreenY();

        if (getWorldX() + TILE_SIZE > getGamePanel().getCurrentPlayer().getWorldX() - getGamePanel().getCurrentPlayer().getScreenX() &&
                getWorldX() - TILE_SIZE < getGamePanel().getCurrentPlayer().getWorldX() + getGamePanel().getCurrentPlayer().getScreenX() &&
                getWorldY() + TILE_SIZE > getGamePanel().getCurrentPlayer().getWorldY() - getGamePanel().getCurrentPlayer().getScreenY() &&
                getWorldY() - TILE_SIZE < getGamePanel().getCurrentPlayer().getWorldY() + getGamePanel().getCurrentPlayer().getScreenY());
        g2.drawImage(this.getDown(0).getSpriteImage(), screenX, screenY, this.getDown(0).getWidth(), this.getDown(0).getHeight(), null);
    }
}
