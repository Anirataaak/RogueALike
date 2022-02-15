/*  Created on 06.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item.items;

import de.regitstudios.rogueALike.objects.sprites.Sprites;
import de.regitstudios.rogueALike.gui.interfaces.GameInterface;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.objects.item.Item;

import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_PLANT;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class PlantItem extends Item {

    public PlantItem(int worldX, int worldY) {
        super(SPRITE_ITEM_PLANT, "plant", true, worldX, worldY);
    }

    @Override
    public void collisionEvent(Player player, GameInterface gamePanel) {
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {
        setSprite(Sprites.SPRITE_ITEM_PLANT_CUT);
        setCollision(false);
    }
}
