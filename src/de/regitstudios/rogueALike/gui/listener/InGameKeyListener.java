/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.listener;

import de.regitstudios.rogueALike.gui.interfaces.GameInterface;

import java.awt.event.KeyEvent;

import static de.regitstudios.rogueALike.constants.GameConstants.INVENTORY_STATE;
import static de.regitstudios.rogueALike.constants.GameConstants.PLAY_STATE;
import static de.regitstudios.rogueALike.objects.sounds.Sounds.*;
import static de.regitstudios.rogueALike.game.RogueALikeGame.DEBUG;
import static de.regitstudios.rogueALike.utils.SoundUtil.playSoundOnce;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class InGameKeyListener implements java.awt.event.KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, actionPressed;
    private GameInterface gamePanel;

    public InGameKeyListener(GameInterface gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> upPressed = true;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> downPressed = true;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> leftPressed = true;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> rightPressed = true;
            case KeyEvent.VK_E -> actionPressed = true;
            case KeyEvent.VK_P -> {
                if (gamePanel.getCurrentState() == PLAY_STATE) {
                    gamePanel.setCurrentState(INVENTORY_STATE);
                } else if (gamePanel.getCurrentState() == INVENTORY_STATE) {
                    gamePanel.setCurrentState(PLAY_STATE);
                }
            }
            case KeyEvent.VK_1 -> {
                if (DEBUG) {
                    gamePanel.getCurrentPlayer().setGemCount(gamePanel.getCurrentPlayer().getGemCount() + 1);
                    playSoundOnce(SOUND_GEM_PICKUP);
                }
            }
            case KeyEvent.VK_2 -> {
                if (DEBUG) {
                    gamePanel.getCurrentPlayer().setBombCount(gamePanel.getCurrentPlayer().getBombCount() + 1);
                    playSoundOnce(SOUND_PICKUP);
                }
            }
            case KeyEvent.VK_3 -> {
                if (DEBUG) {
                    gamePanel.getCurrentPlayer().setArrowCount(gamePanel.getCurrentPlayer().getArrowCount() + 1);
                    playSoundOnce(SOUND_PICKUP);
                }
            }
            case KeyEvent.VK_4 -> {
                if (DEBUG) {
                    gamePanel.getCurrentPlayer().setKeyCount(gamePanel.getCurrentPlayer().getKeyCount() + 1);
                    playSoundOnce(SOUND_KEY_PICKUP);
                }
            }
            case KeyEvent.VK_5 -> {
                if (DEBUG) {
                    gamePanel.getCurrentPlayer().setMaxHealth(gamePanel.getCurrentPlayer().getMaxHealth() + 2);
                    playSoundOnce(SOUND_CHEST_OPEN);
                }
            }
            case KeyEvent.VK_6 -> {
                if (DEBUG) {
                    gamePanel.getCurrentPlayer().setActHealth(gamePanel.getCurrentPlayer().getActHealth() + 1);
                    playSoundOnce(SOUND_PICKUP);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> upPressed = false;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> downPressed = false;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> leftPressed = false;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> rightPressed = false;
            case KeyEvent.VK_E -> actionPressed = false;
        }
    }
}
