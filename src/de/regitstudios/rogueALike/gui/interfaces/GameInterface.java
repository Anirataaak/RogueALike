/*  Created on 15.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.gui.interfaces;

import de.regitstudios.rogueALike.utils.CollisionUtil;
import de.regitstudios.rogueALike.gui.listener.InGameKeyListener;
import de.regitstudios.rogueALike.objects.maps.Map;
import de.regitstudios.rogueALike.objects.entities.Player;

import java.awt.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class GameInterface extends Interface {

    private InGameKeyListener inGameKeyListener = new InGameKeyListener(this);
    private CollisionUtil collisionUtil = new CollisionUtil(this);

    private Map currentMap;
    private Player currentPlayer = new Player(inGameKeyListener, this);

    private int currentState;

    public GameInterface(){
        setKeyListener(inGameKeyListener);
        addKeyListener(inGameKeyListener);
        setCollisionHandler(collisionUtil);
        setCurrentPlayer(currentPlayer);
    }

    @Override
    public void run() {
        double FPS = 60;
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(this.getThread() != null){

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

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public InGameKeyListener getKeyListener() {
        return inGameKeyListener;
    }

    public void setKeyListener(InGameKeyListener inGameKeyListener) {
        this.inGameKeyListener = inGameKeyListener;
    }

    public CollisionUtil getCollisionHandler() {
        return collisionUtil;
    }

    public void setCollisionHandler(CollisionUtil collisionUtil) {
        this.collisionUtil = collisionUtil;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }
}
