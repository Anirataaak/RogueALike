/*  Created on 07.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item;

import de.regitstudios.rogueALike.gui.interfaces.GameInterface;
import de.regitstudios.rogueALike.utils.SoundUtil;
import de.regitstudios.rogueALike.objects.sounds.Sound;
import de.regitstudios.rogueALike.objects.sprites.Sprite;
import de.regitstudios.rogueALike.objects.entities.Player;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public abstract class PickupItem extends Item {

    private Sound pickupSound;

    public PickupItem(Sprite sprite, String name, boolean collision, int worldX, int worldY, Sound pickupSound) {
        super(sprite, name, collision, worldX, worldY);
        setPickupSound(pickupSound);
    }

    @Override
    public void collisionEvent(Player player, GameInterface gamePanel) {
        SoundUtil.playSoundOnce(pickupSound);
        gamePanel.getCurrentMap().getItems().remove(this);
        pickupEvent(player, gamePanel);
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {

    }

    public abstract void pickupEvent(Player player, GameInterface gamePanel);

    public Sound getPickupSound() {
        return pickupSound;
    }

    public void setPickupSound(Sound pickupSound) {
        this.pickupSound = pickupSound;
    }
}
