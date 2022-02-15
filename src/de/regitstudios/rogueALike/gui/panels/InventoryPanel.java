/*  Created on 07.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.panels;

import java.awt.*;

import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_HUD_CURITEM_INVENTORY;
import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_HUD_ITEM_INVENTORY;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class InventoryPanel extends Panel{

    public void draw(Graphics2D g2){
        g2.drawImage(SPRITE_HUD_ITEM_INVENTORY.getSpriteImage(), 25, 25, null);
        g2.drawImage(SPRITE_HUD_CURITEM_INVENTORY.getSpriteImage(), 550, 25, null);
    }
}