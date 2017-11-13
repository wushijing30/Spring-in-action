package com.wusj.soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by wusj on 2017/10/31.
 */

public class SgtPeppers implements CompactDisc{

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
