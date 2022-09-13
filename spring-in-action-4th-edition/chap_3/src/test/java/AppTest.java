import org.example.exclude.MagicBean;
import org.example.config.BeanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class AppTest {

    @Autowired
    private MagicBean magicBean;

    @Test
    public void magicBeanIsNotNull() {
        Assert.assertNotNull(magicBean);
    }

}
