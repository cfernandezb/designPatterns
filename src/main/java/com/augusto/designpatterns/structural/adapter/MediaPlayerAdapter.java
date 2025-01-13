package com.augusto.designpatterns.structural.adapter;

public class MediaPlayerAdapter implements MediaPlayer {
    private AVIPlayer aviPlayer;

    public MediaPlayerAdapter(AVIPlayer aviPlayer) {
        this.aviPlayer = aviPlayer;
    }

    @Override
    public void play(String fileName){
        aviPlayer.playAVI(fileName);
    }
}
