import org.example.config.ScopeConfig;
import org.example.scope.Notepad;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScopeConfig.class)
public class ScopeTest {

    @Autowired
    private Notepad notepad0;

    @Autowired
    private Notepad notepad1;

    @Test
    public void prototypeScopeTest() {
        Assert.assertNotNull(notepad0);
        Assert.assertNotNull(notepad1);
        Assert.assertNotSame(notepad0, notepad1);
    }
}
