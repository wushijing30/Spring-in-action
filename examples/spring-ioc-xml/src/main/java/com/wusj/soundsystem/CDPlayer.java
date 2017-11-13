package com.wusj.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wusj on 2017/11/4.
 */

public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    /**
     * 构造函数注入
     * @param cd
     */
//    @Autowired
//    public CDPlayer(CompactDisc cd){
//        this.cd = cd;
//    }

    /**
     * 属性注入
     */
    @Autowired
    public void setCompactDisc(CompactDisc compactDisc){
        this.cd = compactDisc;
    }
    public void play() {
        cd.play();
    }
}
