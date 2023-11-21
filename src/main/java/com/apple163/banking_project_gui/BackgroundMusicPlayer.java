package com.apple163.banking_project_gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.util.Duration;

public class BackgroundMusicPlayer {
    private static BackgroundMusicPlayer instance = null;
    private Media media;
    private MediaPlayer mediaPlayer;

    private BackgroundMusicPlayer() {
        String mediaPath = "file:///" + System.getProperty("user.dir").replace("\\", "/") + "/resources/music.mp3";
        this.media = new Media(mediaPath);
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaPlayer.setVolume(0.5);
        this.mediaPlayer.play();
    }
    
        public static BackgroundMusicPlayer getInstance() {
        if (instance == null) {
            instance = new BackgroundMusicPlayer();
        }
        return instance;
    }
}