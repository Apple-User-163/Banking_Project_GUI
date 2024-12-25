package com.apple163.banking_project_gui;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BackgroundMusicPlayer {
    private static final String MUSIC_FILE_PATH = "src/main/resources/music.mp3";
    public static boolean initialised = false;
    private Media media;
    private MediaPlayer mediaPlayer;

    public BackgroundMusicPlayer() {
        this.media = new Media(new File(MUSIC_FILE_PATH).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the music indefinitely
        this.mediaPlayer.setVolume(0.25); // Set the volume to 25%
        this.mediaPlayer.play();
        initialised = true;
    }
}
