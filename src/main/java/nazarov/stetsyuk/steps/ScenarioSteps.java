package nazarov.stetsyuk.steps;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;

public class ScenarioSteps extends BaseSteps {

    @Когда("^тест$")
    public void тест() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("^_^");
    }
}
