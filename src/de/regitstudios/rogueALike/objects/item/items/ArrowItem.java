/*  Created on 07.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item.items;

import de.regitstudios.rogueALike.gui.interfaces.GameInterface;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.objects.item.PickupItem;

import static de.regitstudios.rogueALike.objects.sounds.Sounds.SOUND_PICKUP;
import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_ARROW;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class ArrowItem extends PickupItem {

    public ArrowItem(int worldX, int worldY) {
        super(SPRITE_ITEM_ARROW, "arrow", false, worldX, worldY, SOUND_PICKUP);
    }

    public ArrowItem(){
        super(SPRITE_ITEM_ARROW, "arrow", false, 0, 0, SOUND_PICKUP);
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {

    }

    @Override
    public void pickupEvent(Player player, GameInterface gamePanel) {
        if(player.getArrowCount() <= 99){
            player.setArrowCount(player.getArrowCount() + 3);
        }
    }
}
