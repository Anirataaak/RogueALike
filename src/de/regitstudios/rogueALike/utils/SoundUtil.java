/*  Created on 06.02.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.rogueALike.utils;

import de.regitstudios.rogueALike.objects.sounds.Sound;

import javax.sound.sampled.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class SoundUtil {

    public static void playSoundInLoop(Sound sound) {
        Clip soundClip = createClip(sound);
        assert soundClip != null;
        setVolume(soundClip, .2D);
        soundClip.start();
        soundClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void playSoundOnce(Sound sound){
        Clip soundClip = createClip(sound);
        assert soundClip != null;
        setVolume(soundClip, .3D);
        soundClip.start();
    }

    private static Clip createClip(Sound sound){
        try {
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(sound.getAudioStream());
            return soundClip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setVolume(Clip soundClip, double gain){
        FloatControl soundControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        soundControl.setValue(dB);
    }
}
