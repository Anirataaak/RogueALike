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
import de.regitstudios.rogueALike.objects.item.PickupItem;

import static de.regitstudios.rogueALike.objects.sounds.Sounds.SOUND_KEY_PICKUP;
import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_KEY;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class KeyItem extends PickupItem {

    public KeyItem(int worldX, int worldY) {
        super(SPRITE_ITEM_KEY, "Key", false, worldX, worldY, SOUND_KEY_PICKUP);
    }

    public KeyItem(){
        super(SPRITE_ITEM_KEY, "Key", false, 0, 0, SOUND_KEY_PICKUP);
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {

    }

    @Override
    public void pickupEvent(Player player, GameInterface gamePanel) {
        if(player.getKeyCount() <= 9){
            player.setKeyCount(player.getKeyCount() + 1);
        }
    }
}
