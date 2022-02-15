/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.tiles;

import de.regitstudios.rogueALike.objects.sprites.Sprite;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Tile {

    private Sprite sprite;
    private boolean collision = false;
    private int index;

    public Tile(Sprite sprite, int index, boolean collision){
        setSprite(sprite);
        this.index = index;
        setCollision(collision);
    }

    public Tile(Sprite sprite, int index){
        setSprite(sprite);
        this.index = index;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
