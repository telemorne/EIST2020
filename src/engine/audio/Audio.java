package engine.audio;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class Audio {
    private static Audio instance;

    private Audio(){}

    public static Audio getInstance() {
        if(instance==null) instance = new Audio();
        return instance;
    }

    public static void init() {
        getInstance();
    }

    public void playSound(Sound sound) {
        sound.clip.play();
    }

    public enum Sound {
        CLICK("click.wav"), BING("bing.wav");

        private AudioClip clip;

        private Sound(String url) {
            this.clip = new AudioClip(getClass().getClassLoader().
                    getResource(url).toString());
        }
    }

}


