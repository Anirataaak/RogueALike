/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.handler;

import de.regitstudios.rogueALike.gui.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static de.regitstudios.rogueALike.constants.GameConstants.INVENTORY_STATE;
import static de.regitstudios.rogueALike.constants.GameConstants.PLAY_STATE;
import static de.regitstudios.rogueALike.constants.Sounds.*;
import static de.regitstudios.rogueALike.gui.Game.DEBUG;
import static de.regitstudios.rogueALike.handler.SoundHandler.playSoundOnce;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, actionPressed;
    private GamePanel gamePanel;

    public KeyHandler(GamePanel gamePanel) {
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
                if (gamePanel.gameState == PLAY_STATE) {
                    gamePanel.gameState = INVENTORY_STATE;
                } else if (gamePanel.gameState == INVENTORY_STATE) {
                    gamePanel.gameState = PLAY_STATE;
                }
            }
            case KeyEvent.VK_1 -> {
                if (DEBUG) {
                    gamePanel.player.setGemCount(gamePanel.player.getGemCount() + 1);
                    playSoundOnce(SOUND_GEM_PICKUP);
                }
            }
            case KeyEvent.VK_2 -> {
                if (DEBUG) {
                    gamePanel.player.setBombCount(gamePanel.player.getBombCount() + 1);
                    playSoundOnce(SOUND_PICKUP);
                }
            }
            case KeyEvent.VK_3 -> {
                if (DEBUG) {
                    gamePanel.player.setArrowCount(gamePanel.player.getArrowCount() + 1);
                    playSoundOnce(SOUND_PICKUP);
                }
            }
            case KeyEvent.VK_4 -> {
                if (DEBUG) {
                    gamePanel.player.setKeyCount(gamePanel.player.getKeyCount() + 1);
                    playSoundOnce(SOUND_KEY_PICKUP);
                }
            }
            case KeyEvent.VK_5 -> {
                if (DEBUG) {
                    gamePanel.player.setMaxHealth(gamePanel.player.getMaxHealth() + 2);
                    playSoundOnce(SOUND_CHEST_OPEN);
                }
            }
            case KeyEvent.VK_6 -> {
                if (DEBUG) {
                    gamePanel.player.setActHealth(gamePanel.player.getActHealth() + 1);
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
