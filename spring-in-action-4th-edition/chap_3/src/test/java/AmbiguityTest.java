import org.example.ambiguity.Dish;
import org.example.config.AmbiguityConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmbiguityConfig.class)
public class AmbiguityTest {

    @Autowired
    private Dish dish;

    @Test
    public void dessertIsNotNull() {
        Assert.assertNotNull(dish.getDessert());
    }

}
