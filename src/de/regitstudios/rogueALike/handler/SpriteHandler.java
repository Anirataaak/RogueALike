/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.handler;

import de.regitstudios.rogueALike.constants.Sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class SpriteHandler {

    public static BufferedImage returnImage(String spriteType, String spriteName) {
        try {
            return ImageIO.read(Objects.requireNonNull(Sprites.class.getResourceAsStream(spriteType + spriteName)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
