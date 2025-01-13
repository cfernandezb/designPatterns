package com.augusto.designpatterns.structural.adapter;

public class MP4Player implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
