/*  Created on 07.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui;

import java.awt.*;

import static de.regitstudios.rogueALike.constants.Sprites.SPRITE_HUD_CURITEM_INVENTORY;
import static de.regitstudios.rogueALike.constants.Sprites.SPRITE_HUD_ITEM_INVENTORY;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Inventory {

    private GamePanel gamePanel;

    public Inventory(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(SPRITE_HUD_ITEM_INVENTORY.getSpriteImage(), 25, 25, null);
        g2.drawImage(SPRITE_HUD_CURITEM_INVENTORY.getSpriteImage(), 550, 25, null);
    }
}
