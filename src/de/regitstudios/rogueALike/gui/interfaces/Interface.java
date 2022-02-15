/*  Created on 15.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.interfaces;

import javax.swing.*;
import java.awt.*;

import static de.regitstudios.rogueALike.constants.GUIConstants.SCREEN_HEIGHT;
import static de.regitstudios.rogueALike.constants.GUIConstants.SCREEN_WIDTH;
import static java.awt.Color.BLACK;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public abstract class Interface extends JPanel implements Runnable {

    private Thread interfaceThread;

    public Interface(){
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        initializeThread();
    }

    public void initializeThread(){
        this.interfaceThread = new Thread(this);
    }

    public void startThread(){
        this.interfaceThread.start();
    }

    public Thread getThread(){
        return this.interfaceThread;
    }
}
