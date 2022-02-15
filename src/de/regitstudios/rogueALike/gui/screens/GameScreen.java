/*  Created on 15.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.screens;

import javax.swing.*;
import java.awt.*;

import static de.regitstudios.rogueALike.constants.GUIConstants.SCREEN_HEIGHT;
import static de.regitstudios.rogueALike.constants.GUIConstants.SCREEN_WIDTH;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class GameScreen extends JFrame {

    public GameScreen(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("RogueALike Game");
        setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    }
}
