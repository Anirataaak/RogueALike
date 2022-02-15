/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects;

import java.awt.image.BufferedImage;

import static de.regitstudios.rogueALike.handler.SpriteHandler.returnImage;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Sprite {

    private BufferedImage spriteImage;
    private String spriteName;
    private String spriteType;

    public Sprite(String spriteType, String spriteName){
        setSpriteName(spriteName);
        setSpriteType(spriteType);
        setSpriteImage(returnImage(spriteType, spriteName));
    }

    public int getWidth() {
        return getSpriteImage().getWidth() * 3;
    }

    public int getHeight() {
        return getSpriteImage().getHeight() * 3;
    }

    public BufferedImage getSpriteImage() {
        return spriteImage;
    }

    public String getSpriteType() {
        return spriteType;
    }

    public void setSpriteType(String spriteType) {
        this.spriteType = spriteType;
    }

    public void setSpriteImage(BufferedImage spriteImage) {
        this.spriteImage = spriteImage;
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
