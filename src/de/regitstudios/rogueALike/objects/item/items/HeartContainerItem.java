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

import static de.regitstudios.rogueALike.objects.sounds.Sounds.SOUND_CHEST_OPEN;
import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_HEART_CONTAINER;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class HeartContainerItem extends PickupItem {

    public HeartContainerItem(int worldX, int worldY) {
        super(SPRITE_ITEM_HEART_CONTAINER, "heart_container", false, worldX, worldY, SOUND_CHEST_OPEN);
    }

    public HeartContainerItem(){
        super(SPRITE_ITEM_HEART_CONTAINER, "heart_container", false, 0, 0, SOUND_CHEST_OPEN);
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {

    }

    @Override
    public void pickupEvent(Player player, GameInterface gamePanel) {
        if(player.getMaxHealth() <= 40){
            player.setMaxHealth(player.getMaxHealth() + 2);
            player.setActHealth(player.getMaxHealth());
        }
    }
}
