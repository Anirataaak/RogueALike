/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.interfaces;

import de.regitstudios.rogueALike.game.RogueALikeGame;
import de.regitstudios.rogueALike.gui.panels.InventoryPanel;
import de.regitstudios.rogueALike.gui.panels.UI;
import de.regitstudios.rogueALike.objects.maps.Map;
import de.regitstudios.rogueALike.objects.entities.Villager;
import de.regitstudios.rogueALike.objects.item.Item;

import java.awt.*;

import static de.regitstudios.rogueALike.constants.GameConstants.INVENTORY_STATE;
import static de.regitstudios.rogueALike.constants.GameConstants.PLAY_STATE;
import static de.regitstudios.rogueALike.objects.sounds.Sounds.SOUND_OVERWORLD_THEME;
import static de.regitstudios.rogueALike.utils.SoundUtil.playSoundInLoop;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class InGameInterface extends GameInterface {

    private Map curMap;

    private final UI ui = new UI(this);
    private final InventoryPanel inventory = new InventoryPanel();
    private final Villager testvillager = new Villager(this);

    public InGameInterface(Map map){
        if(!RogueALikeGame.DEBUG){
            playSoundInLoop(SOUND_OVERWORLD_THEME);
        }
        setCurrentState(PLAY_STATE);
        setCurrentMap(map);
    }

    @Override
    public void update() {
        if(getCurrentState() == PLAY_STATE){
            getCurrentPlayer().update();
        } else if(getCurrentState() == INVENTORY_STATE) {

        }
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        getCurrentMap().draw(g2, this);

        for(Item item : getCurrentMap().getItems()){
            if(item != null){
                item.draw(g2, this);
            }
        }
        testvillager.draw(g2);
        getCurrentPlayer().draw(g2);

        if(getCurrentState() == INVENTORY_STATE){
            inventory.draw(g2);
        } else {
            ui.draw(g2);
        }

        g2.dispose();
    }
}
