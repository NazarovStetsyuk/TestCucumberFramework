import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"nazarov.stetsyuk"},
        plugin = {
                "nazarov.stetsyuk.utils.AllureReporter",
        }
)

public class CucumberRunner {
}