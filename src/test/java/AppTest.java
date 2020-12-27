import org.junit.Assert;
import org.junit.Test;
import school.siit.App;

public class AppTest {

    @Test
    public void readAndWrite(){
        App app = new App();
        Assert.assertTrue(app.readAndWrite("input", 8, "output"));
    }
}
