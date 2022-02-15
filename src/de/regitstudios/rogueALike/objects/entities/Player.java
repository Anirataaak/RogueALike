/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects.entities;

import de.regitstudios.rogueALike.constants.GUIConstants;
import de.regitstudios.rogueALike.game.RogueALikeGame;
import de.regitstudios.rogueALike.gui.interfaces.GameInterface;
import de.regitstudios.rogueALike.gui.interfaces.InGameInterface;
import de.regitstudios.rogueALike.gui.listener.InGameKeyListener;
import de.regitstudios.rogueALike.objects.sprites.Sprite;
import de.regitstudios.rogueALike.objects.item.Item;

import java.awt.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Player extends Entity {

    private final InGameKeyListener inGameKeyListener;
    public final int screenX, screenY;
    private GameInterface gamePanel;
    private int keyCount = 0;
    private int gemCount = 0;
    private int bombCount = 0;
    private int arrowCount = 0;
    private int maxHealth = 24;
    private int actHealth = 11;
    private boolean isLowOnHealth = false;

    public Player(InGameKeyListener inGameKeyListener, GameInterface gamePanel){
        super(gamePanel);
        this.inGameKeyListener = inGameKeyListener;
        screenX = SCREEN_WIDTH / 2 - (TILE_SIZE / 2);
        screenY = SCREEN_HEIGHT / 2 - (TILE_SIZE / 2);
        getSolidArea().x = 8;
        getSolidArea().y = 36;
        getSolidArea().width = 32;
        getSolidArea().height = 32;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        setDefaultValues();
        setEntityImage();
        this.gamePanel = gamePanel;
    }

    public void setDefaultValues() {
        super.setDefaultValues(TILE_SIZE * 6, TILE_SIZE * 6, 4, DIR_DOWN);
    }

    @Override
    public void setEntityImage(){
        addUpAnimation(new Sprite[]{SPRITE_PLAYER_WALKING_UP_1, SPRITE_PLAYER_WALKING_UP_2, SPRITE_PLAYER_WALKING_UP_3,
                                    SPRITE_PLAYER_WALKING_UP_4, SPRITE_PLAYER_WALKING_UP_5, SPRITE_PLAYER_WALKING_UP_6,
                                    SPRITE_PLAYER_WALKING_UP_7, SPRITE_PLAYER_WALKING_UP_8, SPRITE_PLAYER_WALKING_UP_9});

        addDownAnimation(new Sprite[]{SPRITE_PLAYER_WALKING_DOWN_1, SPRITE_PLAYER_WALKING_DOWN_2, SPRITE_PLAYER_WALKING_DOWN_3,
                                      SPRITE_PLAYER_WALKING_DOWN_4, SPRITE_PLAYER_WALKING_DOWN_5, SPRITE_PLAYER_WALKING_DOWN_6,
                                      SPRITE_PLAYER_WALKING_DOWN_7, SPRITE_PLAYER_WALKING_DOWN_8, SPRITE_PLAYER_WALKING_DOWN_9});

        addLeftAnimation(new Sprite[]{SPRITE_PLAYER_WALKING_LEFT_1, SPRITE_PLAYER_WALKING_LEFT_2, SPRITE_PLAYER_WALKING_LEFT_3,
                                      SPRITE_PLAYER_WALKING_LEFT_4, SPRITE_PLAYER_WALKING_LEFT_5, SPRITE_PLAYER_WALKING_LEFT_6,
                                      SPRITE_PLAYER_WALKING_LEFT_7, SPRITE_PLAYER_WALKING_LEFT_8, SPRITE_PLAYER_WALKING_LEFT_9});

        addRightAnimation(new Sprite[]{SPRITE_PLAYER_WALKING_RIGHT_1, SPRITE_PLAYER_WALKING_RIGHT_2, SPRITE_PLAYER_WALKING_RIGHT_3,
                                       SPRITE_PLAYER_WALKING_RIGHT_4, SPRITE_PLAYER_WALKING_RIGHT_5, SPRITE_PLAYER_WALKING_RIGHT_6,
                                       SPRITE_PLAYER_WALKING_RIGHT_7, SPRITE_PLAYER_WALKING_RIGHT_8, SPRITE_PLAYER_WALKING_RIGHT_9});
    }

    public void update(){

        if(inGameKeyListener.upPressed || inGameKeyListener.downPressed || inGameKeyListener.leftPressed || inGameKeyListener.rightPressed){

            if(inGameKeyListener.upPressed) {
                setDirection(DIR_UP);
            }
            if(inGameKeyListener.downPressed) {
                setDirection(DIR_DOWN);
            }
            if(inGameKeyListener.leftPressed) {
                setDirection(DIR_LEFT);
            }
            if(inGameKeyListener.rightPressed) {
                setDirection(DIR_RIGHT);
            }

            // Check Tile Collision
            setCollisionOn(false);
            gamePanel.getCollisionHandler().checkTileForCollision(this);

            // Check Item Collision
            Item collisionItem = gamePanel.getCollisionHandler().checkObjectCollision(this, true);
            pickUpObject(collisionItem, this);

            // If Collision is false, player can move
            if(!isCollisionOn()){
                switch(getDirection()){
                    case GUIConstants.DIR_UP -> setWorldY(getWorldY() - getSpeed());
                    case GUIConstants.DIR_DOWN -> setWorldY(getWorldY() + getSpeed());
                    case GUIConstants.DIR_LEFT -> setWorldX(getWorldX() - getSpeed());
                    case GUIConstants.DIR_RIGHT -> setWorldX(getWorldX() + getSpeed());
                }
            }

            setSpriteCounter(getSpriteCounter() + 1);
            if(getSpriteCounter() > 1){
                switch (getSpriteNum()){
                    case 1 -> setSpriteNum(2);
                    case 2 -> setSpriteNum(3);
                    case 3 -> setSpriteNum(4);
                    case 4 -> setSpriteNum(5);
                    case 5 -> setSpriteNum(6);
                    case 6 -> setSpriteNum(7);
                    case 7 -> setSpriteNum(8);
                    case 8 -> setSpriteNum(9);
                    case 9 -> setSpriteNum(1);
                }
                setSpriteCounter(0);
            }
        } else{
            setSpriteNum(1);
        }

        if (inGameKeyListener.actionPressed) {
            Item nextItem = gamePanel.getCollisionHandler().checkObjectCollision(this, true);
            if (nextItem != null) {
                nextItem.actionEvent(this, gamePanel);
                gamePanel.getKeyListener().actionPressed = false;
            }
        }
    }

    public void pickUpObject(Item item, Player player){
        if(item != null){
            item.collisionEvent(player, gamePanel);
        }
    }

    public void draw(Graphics2D g2){

        Sprite curPlayerImage = null;

        switch(getDirection()){
            case DIR_UP -> {
                switch(getSpriteNum()){
                    case 1 -> {
                        curPlayerImage = getUp(0);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 2 -> {
                        curPlayerImage = getUp(1);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 3 -> {
                        curPlayerImage = getUp(2);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 4 -> {
                        curPlayerImage = getUp(3);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 5 -> {
                        curPlayerImage = getUp(4);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 6 -> {
                        curPlayerImage = getUp(5);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 7 -> {
                        curPlayerImage = getUp(6);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 8 -> {
                        curPlayerImage = getUp(7);
                        drawPlayer(g2, curPlayerImage);
                    }
                    case 9 -> {
                        curPlayerImage = getUp(8);
                        drawPlayer(g2, curPlayerImage);
                    }
                }
            }
            case DIR_DOWN -> {
                if(getSpriteNum() == 1){
                    curPlayerImage = getDown(0);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 2){
                    curPlayerImage = getDown(1);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 3){
                    curPlayerImage = getDown(2);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 4){
                    curPlayerImage = getDown(3);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 5){
                    curPlayerImage = getDown(4);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 6) {
                    curPlayerImage = getDown(5);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 7) {
                    curPlayerImage = getDown(6);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 8) {
                    curPlayerImage = getDown(7);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 9) {
                    curPlayerImage = getDown(8);
                    drawPlayer(g2, curPlayerImage);
                }
            }
            case DIR_LEFT -> {
                if(getSpriteNum() == 1){
                    curPlayerImage = getLeft(0);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 2){
                    curPlayerImage = getLeft(1);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 3){
                    curPlayerImage = getLeft(2);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 4){
                    curPlayerImage = getLeft(3);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 5){
                    curPlayerImage = getLeft(4);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 6){
                    curPlayerImage = getLeft(5);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 7){
                    curPlayerImage = getLeft(6);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 8){
                    curPlayerImage = getLeft(7);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 9){
                    curPlayerImage = getLeft(8);
                    drawPlayer(g2, curPlayerImage);
                }
            }
            case DIR_RIGHT -> {
                if(getSpriteNum() == 1){
                    curPlayerImage = getRight(0);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 2){
                    curPlayerImage = getRight(1);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 3){
                    curPlayerImage = getRight(2);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 4){
                    curPlayerImage = getRight(3);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 5){
                    curPlayerImage = getRight(4);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 6){
                    curPlayerImage = getRight(5);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 7){
                    curPlayerImage = getRight(6);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 8){
                    curPlayerImage = getRight(7);
                    drawPlayer(g2, curPlayerImage);
                } else if(getSpriteNum() == 9){
                    curPlayerImage = getRight(8);
                    drawPlayer(g2, curPlayerImage);
                }
            }
        }
    }

    public void drawPlayer(Graphics2D g2, Sprite curSprite){
        g2.drawImage(curSprite.getSpriteImage(), screenX, screenY, curSprite.getWidth(), curSprite.getHeight(), null);
        if(RogueALikeGame.DEBUG){
            g2.setColor(Color.RED);
            g2.drawRect(screenX + getSolidArea().x, screenY + getSolidArea().y, getSolidArea().width, getSolidArea().height);
        }
    }

    public InGameKeyListener getKeyListener() {
        return inGameKeyListener;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public GameInterface getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(InGameInterface gamePanel) {
        this.gamePanel = gamePanel;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public int getGemCount() {
        return gemCount;
    }

    public void setGemCount(int gemCount) {
        this.gemCount = gemCount;
    }

    public int getBombCount() {
        return bombCount;
    }

    public void setBombCount(int bombCount) {
        this.bombCount = bombCount;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getActHealth() {
        return actHealth;
    }

    public void setActHealth(int actHealth) {
        this.actHealth = actHealth;
    }

    public boolean isLowOnHealth() {
        return isLowOnHealth;
    }

    public void setLowOnHealth(boolean lowOnHealth) {
        isLowOnHealth = lowOnHealth;
    }
}
