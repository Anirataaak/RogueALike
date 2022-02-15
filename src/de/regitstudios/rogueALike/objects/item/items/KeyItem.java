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
import de.regitstudios.rogueALike.objects.item.PickupItem;

import static de.regitstudios.rogueALike.constants.Sounds.SOUND_KEY_PICKUP;
import static de.regitstudios.rogueALike.constants.Sprites.SPRITE_ITEM_KEY;

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
    public void actionEvent(Player player, GamePanel gamePanel) {

    }

    @Override
    public void pickupEvent(Player player, GamePanel gamePanel) {
        if(player.getKeyCount() <= 9){
            player.setKeyCount(player.getKeyCount() + 1);
        }
    }
}
