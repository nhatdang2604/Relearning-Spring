package com.example.soundsystem;

import com.example.config.CDPlayerConfig;
import com.example.config.SoundSystemConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= CDPlayerConfig.class)
//@ContextConfiguration(
//        locations = {"file:src/main/resources/CDConfig.xml"}
//)
//@ContextConfiguration(
//        locations = {"file:src/main/resources/CDConfig_0.xml"}
//)
@ContextConfiguration(
        locations = {"file:src/main/resources/CDConfig_1.xml"}
)
//@ContextConfiguration(classes = SoundSystemConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog logger =
            new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;
    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        logger.clear();
        player.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
                logger.getLog()
        );

    }

}
