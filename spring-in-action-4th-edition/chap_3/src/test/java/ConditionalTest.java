import org.example.exclude.MagicBean;
import org.example.config.ConditionalConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionalConfig.class)
public class ConditionalTest {

    @Autowired
    private MagicBean magicBean;

    @Test
    public void magicBeanIsNotNull() {
        Assert.assertNotNull(magicBean);
    }

}
