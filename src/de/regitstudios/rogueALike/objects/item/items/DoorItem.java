/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item.items;

import de.regitstudios.rogueALike.gui.interfaces.GameInterface;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.objects.item.Item;

import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_DOOR;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class DoorItem extends Item {

    public DoorItem(int worldX, int worldY) {
        super(SPRITE_ITEM_DOOR, "Door", true, worldX, worldY);
    }

    @Override
    public void collisionEvent(Player player, GameInterface gamePanel) {
        if(player.getKeyCount() > 0){
            gamePanel.getCurrentMap().getItems().remove(this);
            player.setKeyCount(player.getKeyCount() - 1);
        }
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {

    }
}
