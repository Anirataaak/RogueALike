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
import de.regitstudios.rogueALike.objects.item.PickupItem;

import static de.regitstudios.rogueALike.objects.sounds.Sounds.SOUND_CHEST_OPEN;
import static de.regitstudios.rogueALike.objects.sounds.Sounds.SOUND_ERROR;
import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_CHEST;
import static de.regitstudios.rogueALike.objects.sprites.Sprites.SPRITE_ITEM_CHEST_OPEN;
import static de.regitstudios.rogueALike.utils.SoundUtil.playSoundOnce;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class ChestItem extends Item {

    private boolean needsKey = false;
    private boolean open = false;
    private PickupItem reward;

    public ChestItem(int worldX, int worldY, PickupItem reward, boolean needsKey) {
        super(SPRITE_ITEM_CHEST, "Chest", true, worldX, worldY);
        setNeedsKey(needsKey);
        setReward(reward);
    }

    @Override
    public void collisionEvent(Player player, GameInterface gamePanel) {
    }

    @Override
    public void actionEvent(Player player, GameInterface gamePanel) {
        if(player.getKeyCount() > 0 && !isOpen()) {
            setSprite(SPRITE_ITEM_CHEST_OPEN);
            player.setKeyCount(player.getKeyCount() - 1);
            getReward().pickupEvent(player, gamePanel);
            playSoundOnce(SOUND_CHEST_OPEN);
            setOpen();
        } else if(player.getKeyCount() == 0 && !isOpen()){
            playSoundOnce(SOUND_ERROR);
        }
    }

    public boolean isNeedsKey() {
        return needsKey;
    }

    public void setNeedsKey(boolean needsKey) {
        this.needsKey = needsKey;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen() {
        this.open = true;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public PickupItem getReward() {
        return reward;
    }

    public void setReward(PickupItem reward) {
        this.reward = reward;
    }
}
