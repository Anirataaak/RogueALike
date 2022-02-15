/*  Created on 03.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui;

import de.regitstudios.rogueALike.constants.GUIConstants;
import de.regitstudios.rogueALike.handler.CollisionHandler;
import de.regitstudios.rogueALike.objects.Map;
import de.regitstudios.rogueALike.objects.entities.Player;
import de.regitstudios.rogueALike.handler.KeyHandler;
import de.regitstudios.rogueALike.objects.entities.Villager;
import de.regitstudios.rogueALike.objects.item.Item;

import javax.swing.*;
import java.awt.*;

import static de.regitstudios.rogueALike.constants.GameConstants.INVENTORY_STATE;
import static de.regitstudios.rogueALike.constants.GameConstants.PLAY_STATE;
import static de.regitstudios.rogueALike.constants.Sounds.SOUND_OVERWORLD_THEME;
import static de.regitstudios.rogueALike.handler.SoundHandler.playSoundInLoop;
import static java.awt.Color.BLACK;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class GamePanel extends JPanel implements GUIConstants, Runnable {

    private Thread gameThread;
    public final KeyHandler keyListener = new KeyHandler(this);
    public final CollisionHandler collisionHandler = new CollisionHandler(this);

    public final Player player = new Player(keyListener, this);

    private Map curMap;

    private final UI ui = new UI(this);
    public int gameState;

    private final Inventory inventory = new Inventory(this);

    public final Villager testvillager = new Villager(this);

    public GamePanel(){

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        if(!Game.DEBUG){
            playSoundInLoop(SOUND_OVERWORLD_THEME);
        }
        gameState = PLAY_STATE;
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if(gameState == PLAY_STATE){
            player.update();
        } else if(gameState == INVENTORY_STATE) {

        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        getCurrentMap().draw(g2, this);

        for(Item item : getCurrentMap().getItems()){
            if(item != null){
                item.draw(g2, this);
            }
        }

        player.draw(g2);
        testvillager.draw(g2);

        if(gameState == INVENTORY_STATE){
            inventory.draw(g2);
        } else {
            ui.draw(g2);
        }

        g2.dispose();
    }

    public void setCurrentMap(Map nextMap){
        this.curMap = nextMap;
    }

    public Map getCurrentMap(){
        return this.curMap;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }
}
