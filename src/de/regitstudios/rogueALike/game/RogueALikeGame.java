/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.game;

import de.regitstudios.rogueALike.constants.GUIConstants;
import de.regitstudios.rogueALike.gui.interfaces.InGameInterface;
import de.regitstudios.rogueALike.gui.screens.GameScreen;

import static de.regitstudios.rogueALike.objects.maps.Maps.MAIN_MAP;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class RogueALikeGame implements GUIConstants {

    public static boolean DEBUG = true;

    public static void main(String[] args) {

        GameScreen rogueALikeScreen = new GameScreen();

        InGameInterface gamePanel = new InGameInterface(MAIN_MAP);
        rogueALikeScreen.add(gamePanel);

        rogueALikeScreen.pack();
        rogueALikeScreen.setLocationRelativeTo(null);
        rogueALikeScreen.setVisible(true);

        gamePanel.startThread();
    }
}