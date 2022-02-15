/*  Created on 15.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public abstract class Panel extends JPanel {

    public abstract void draw(Graphics2D g2);
}
