package com.interstellarchef.gui;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

    Clip clip;
    URL[] soundURL = new URL[30];
    private FloatControl volume;

    public Sound() {
        soundURL[0] = getClass().getResource("/sound/happysong.wav");
        soundURL[1] = getClass().getResource("/sound/scarysong.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-5f);
        } catch (Exception ignored) {
        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }

    public void volumeDown() {
        if (volume != null) {
            volume.setValue(-10f);
        }
    }

    public void volumeUp(){
        float newVolume = volume.getValue()+ 10f;
        volume.setValue(Math.min(newVolume, volume.getMaximum()));
    }





}