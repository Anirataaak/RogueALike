/*  Created on 06.02.2022
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

import static de.regitstudios.rogueALike.constants.Sounds.SOUND_GEM_PICKUP;
import static de.regitstudios.rogueALike.constants.Sprites.SPRITE_ITEM_BLUE_GEM;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class BlueGemItem extends PickupItem {

    public BlueGemItem(int worldX, int worldY) {
        super(SPRITE_ITEM_BLUE_GEM, "blue_gem", false, worldX, worldY, SOUND_GEM_PICKUP);
    }

    public BlueGemItem(){
        super(SPRITE_ITEM_BLUE_GEM, "blue_gem", false, 0, 0, SOUND_GEM_PICKUP);
    }

    @Override
    public void actionEvent(Player player, GamePanel gamePanel) {

    }

    @Override
    public void pickupEvent(Player player, GamePanel gamePanel) {
        if(player.getGemCount() <= 999){
            player.setGemCount(player.getGemCount() + 5);
        }
    }
}
