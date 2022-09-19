import org.example.concert.MetalPerformance;
import org.example.concert.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config.xml")
public class PerformanceTest {
    @Autowired
    private Performance performance;

    @Test
    public void performanceTest() {
        performance.perform();
    }
}
