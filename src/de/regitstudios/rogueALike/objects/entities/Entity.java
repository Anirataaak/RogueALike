/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.entities;

import de.regitstudios.rogueALike.constants.GUIConstants;
import de.regitstudios.rogueALike.objects.sprites.Sprites;
import de.regitstudios.rogueALike.gui.interfaces.GameInterface;
import de.regitstudios.rogueALike.objects.sprites.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public abstract class Entity implements GUIConstants, Sprites {

    private int worldX, worldY;
    private int speed;

    private GameInterface gamePanel;

    private List<Sprite> upAnimation = new ArrayList<>();
    private List<Sprite> downAnimation = new ArrayList<>();
    private List<Sprite> leftAnimation = new ArrayList<>();
    private List<Sprite> rightAnimation = new ArrayList<>();

    private String direction;

    private int spriteCounter = 0;
    private int spriteNum = 1;
    private int screenX, screenY;

    private int solidAreaDefaultX, solidAreaDefaultY;

    private Rectangle solidArea = new Rectangle();
    private boolean collisionOn = false;

    public abstract void setEntityImage();

    public void setDefaultValues(int worldX, int worldY, int speed, String direction) {
        setWorldX(worldX);
        setWorldY(worldY);
        setSpeed(speed);
        setDirection(direction);
        setScreenX(SCREEN_WIDTH / 2 - (TILE_SIZE / 2));
        setScreenY(SCREEN_HEIGHT / 2 - (TILE_SIZE / 2));
    }

    public abstract void update();

    public abstract void draw(Graphics2D g2);

    public GameInterface getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GameInterface gamePanel) {
        this.gamePanel = gamePanel;
    }

    public int getScreenX() {
        return screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }

    public Entity(GameInterface gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void addUpAnimation(Sprite sprite) {
        upAnimation.add(sprite);
    }

    public void addUpAnimation(Sprite[] sprites) {
        upAnimation.addAll(Arrays.asList(sprites));
    }

    public Sprite getUp(int index) {
        return upAnimation.get(index);
    }

    public void addDownAnimation(Sprite sprite) {
        downAnimation.add(sprite);
    }

    public void addDownAnimation(Sprite[] sprites) {
        downAnimation.addAll(Arrays.asList(sprites));
    }

    public Sprite getDown(int index) {
        return downAnimation.get(index);
    }

    public void addLeftAnimation(Sprite sprite) {
        leftAnimation.add(sprite);
    }

    public void addLeftAnimation(Sprite[] sprites) {
        leftAnimation.addAll(Arrays.asList(sprites));
    }

    public Sprite getLeft(int index) {
        return leftAnimation.get(index);
    }

    public void addRightAnimation(Sprite sprite) {
        rightAnimation.add(sprite);
    }

    public void addRightAnimation(Sprite[] sprites) {
        rightAnimation.addAll(Arrays.asList(sprites));
    }

    public Sprite getRight(int index) {
        return rightAnimation.get(index);
    }

    public List<Sprite> getUpAnimation() {
        return upAnimation;
    }

    public void setUpAnimation(List<Sprite> upAnimation) {
        this.upAnimation = upAnimation;
    }

    public List<Sprite> getDownAnimation() {
        return downAnimation;
    }

    public void setDownAnimation(List<Sprite> downAnimation) {
        this.downAnimation = downAnimation;
    }

    public List<Sprite> getLeftAnimation() {
        return leftAnimation;
    }

    public void setLeftAnimation(List<Sprite> leftAnimation) {
        this.leftAnimation = leftAnimation;
    }

    public List<Sprite> getRightAnimation() {
        return rightAnimation;
    }

    public void setRightAnimation(List<Sprite> rightAnimation) {
        this.rightAnimation = rightAnimation;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
