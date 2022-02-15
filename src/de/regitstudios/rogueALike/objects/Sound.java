/*  Created on 04.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Sound {

    private String soundPath;
    private String soundName;

    public Sound(String soundPath, String soundName){
        setSoundName(soundName);
        setSoundPath(soundPath);
    }

    public AudioInputStream getAudioStream(){
        try {
            return AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream(getSoundPath() + getSoundName()));
        } catch (Exception e) {
            return null;
        }
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }
}
