/*  Created on 07.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.item;

import de.regitstudios.rogueALike.gui.GamePanel;
import de.regitstudios.rogueALike.handler.SoundHandler;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.objects.Sound;
import de.regitstudios.rogueALike.objects.Sprite;

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
    public void collisionEvent(Player player, GamePanel gamePanel) {
        SoundHandler.playSoundOnce(pickupSound);
        gamePanel.getCurrentMap().getItems().remove(this);
        pickupEvent(player, gamePanel);
    }

    @Override
    public void actionEvent(Player player, GamePanel gamePanel) {

    }

    public abstract void pickupEvent(Player player, GamePanel gamePanel);

    public Sound getPickupSound() {
        return pickupSound;
    }

    public void setPickupSound(Sound pickupSound) {
        this.pickupSound = pickupSound;
    }
}
