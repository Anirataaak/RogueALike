/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item.items;

import de.regitstudios.rogueALike.gui.GamePanel;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.objects.item.Item;

import static de.regitstudios.rogueALike.constants.Sprites.SPRITE_ITEM_BOOTS;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class BootItem extends Item {

    public BootItem(int worldX, int worldY) {
        super(SPRITE_ITEM_BOOTS, "boots", false, worldX, worldY);
    }

    @Override
    public void collisionEvent(Player player, GamePanel gamePanel) {
        player.setSpeed(player.getSpeed() + 4);
        gamePanel.getCurrentMap().getItems().remove(this);

    }

    @Override
    public void actionEvent(Player player, GamePanel gamePanel) {

    }
}
