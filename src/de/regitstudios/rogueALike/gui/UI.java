/*  Created on 06.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui;

import de.regitstudios.rogueALike.objects.Sprite;

import java.awt.*;
import java.io.File;

import static de.regitstudios.rogueALike.constants.Sprites.*;
import static de.regitstudios.rogueALike.gui.Game.DEBUG;
import static java.awt.Color.WHITE;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class UI {

    private GamePanel gamePanel;

    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void draw(Graphics2D g2){

        Font zeldaFont = null;
        try {
            zeldaFont = Font.createFont(Font.TRUETYPE_FONT, new File(UI.class.getResource("/Font/ReturnofGanon.ttf").toURI())).deriveFont(35f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g2.setFont(zeldaFont);
        g2.setColor(WHITE);
        g2.drawImage(SPRITE_HUD_GEM.getSpriteImage(), 100, 10, 32, 32, null);
        int gemCount = gamePanel.player.getGemCount();
        if(gemCount < 10){
            g2.drawString("00" + gemCount, 97, 70);
        } else if(gemCount < 100){
            g2.drawString("0" + gemCount, 97, 70);
        } else if(gemCount < 1000){
            g2.drawString(String.valueOf(gemCount), 97, 70);
        }
        g2.drawImage(SPRITE_HUD_BOMB.getSpriteImage(), 160, 10, 32, 32, null);
        int bombCount = gamePanel.player.getBombCount();
        if(bombCount < 10){
            g2.drawString("0" + bombCount, 165, 70);
        } else if(bombCount < 100){
            g2.drawString(String.valueOf(bombCount), 165, 70);
        }
        g2.drawImage(SPRITE_HUD_ARROW.getSpriteImage(), 220, 10, 48, 32, null);
        int arrowCount = gamePanel.player.getArrowCount();
        if(arrowCount < 10){
            g2.drawString("0" + arrowCount, 230, 70);
        } else if(arrowCount < 100){
            g2.drawString(String.valueOf(arrowCount), 230, 70);
        }
        g2.drawImage(SPRITE_HUD_KEY.getSpriteImage(), 280, 10, 32, 32, null);
        g2.drawString(String.valueOf(gamePanel.player.getKeyCount()), 290, 70);
        g2.drawImage(SPRITE_HUD_HEART_TITLE.getSpriteImage(), 500, 10, 120, 24, null);
        int maxHealth = gamePanel.player.getMaxHealth();
        drawHealth(SPRITE_HUD_EMPTY_HEART, maxHealth, g2);
        int actHealth = gamePanel.player.getActHealth();
        if(actHealth % 2 == 0){
            drawHealth(SPRITE_HUD_FULL_HEART, actHealth, g2);
        } else {
            int tempHealth = actHealth - 1;
            drawHealth(SPRITE_HUD_FULL_HEART, tempHealth, g2);
            int temp = tempHealth / 2;
            if(temp < 10){
                g2.drawImage(SPRITE_HUD_HALF_HEART.getSpriteImage(), 440 + (temp * 24), 34, 24, 24, null);
            } else {
                g2.drawImage(SPRITE_HUD_HALF_HEART.getSpriteImage(), 440 + ((temp - 10) * 24), 58, 24, 24, null);
            }
        }
        if(DEBUG){
            drawDebug(g2);
        }
    }

    private void drawHealth(Sprite sprite, int healthCount, Graphics2D g2){
        int index = -1;
        for(int i = 0; i < healthCount; i += 2){
            index++;
            if(i < 20){
                g2.drawImage(sprite.getSpriteImage(), 440 + (index * 24), 34, 24, 24, null);
            } else {
                if(index == 10){
                    index = 0;
                }
                g2.drawImage(sprite.getSpriteImage(), 440 + (index * 24), 58, 24, 24, null);
            }
        }
    }

    private void drawDebug(Graphics2D g2){
        Font zeldaFont = null;
        try {
            zeldaFont = Font.createFont(Font.TRUETYPE_FONT, new File(UI.class.getResource("/Font/ReturnofGanon.ttf").toURI())).deriveFont(20f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g2.setFont(zeldaFont);
        g2.drawString("Press 1 for + 1 Gem", 10, 250);
        g2.drawString("Press 2 for + 1 Bomb", 10, 270);
        g2.drawString("Press 3 for + 1 Arrow", 10, 290);
        g2.drawString("Press 4 for + 1 Key", 10, 310);
        g2.drawString("Press 5 for + 1 Heart Container", 10, 330);
        g2.drawString("Press 6 for + 1 Heart", 10, 350);
    }
}
