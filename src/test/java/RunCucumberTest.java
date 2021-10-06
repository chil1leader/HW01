import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps", "hooks"},
        plugin = {"pretty", "json:report.json"},
        tags = "@table1"
)
public class RunCucumberTest {

}
