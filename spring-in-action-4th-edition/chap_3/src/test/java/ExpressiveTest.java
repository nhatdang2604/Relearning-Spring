import org.example.config.ExpressiveConfig;
import org.example.soundsystem.BlankDisc;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExpressiveConfig.class)
public class ExpressiveTest {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void blankDiscPropertyCheck() {
       blankDisc.play();
       Assert.assertNotNull(blankDisc.getTitle());
       Assert.assertNotNull(blankDisc.getArtist());
    }

}
