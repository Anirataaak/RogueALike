/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui;

import de.regitstudios.rogueALike.constants.GUIConstants;

import javax.swing.*;

import static de.regitstudios.rogueALike.constants.Maps.MAIN_MAP;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Game implements GUIConstants {

    public static boolean DEBUG = true;

    public static void main(String[] args) {

        JFrame gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setTitle(GAME_TITLE);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setCurrentMap(MAIN_MAP);
        gameWindow.add(gamePanel);

        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

        gamePanel.startGameThread();
    }
}