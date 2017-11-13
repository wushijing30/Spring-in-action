package com.wusj.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by wusj on 2017/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:ConstructorArgValueTest-context.xml")
@ContextConfiguration("classpath:PropertyRefTest-context.xml")
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();
    }
}
