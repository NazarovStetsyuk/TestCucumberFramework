package nazarov.stetsyuk.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;


public class ScenarioSteps extends BaseSteps {

    ScenarioSubSteps subSteps = new ScenarioSubSteps();

    @When("^выполнено нажатие на поле \"(.+)\"$")
    public void whenFieldIsClicked(String fieldName) {
        subSteps.stepFieldIsClicked(fieldName);
    }

    @When("^поле \"(.+)\" заполняется значением \"(.+)\"$")
    public void whenFieldIsFilledWithValue(String fieldName, String value) {
        subSteps.stepFieldIsFilledWithValue(fieldName, value);
    }

    @When("^поле \"(.+)\" содержит значение \"(.+)\"$")
    public void whenFieldContainsValue(String fieldName, String expectedValue) {
        subSteps.stepFieldContainsValue(fieldName, expectedValue);
    }

    @When("^наводим курсор на поле \"(.+)\"$")
    public void whenMoveCursorToField(String fieldName) {
        subSteps.stepMoveCursorToField(fieldName);
    }

    @Then("^загружена страница \"(.+)\"$")
    public void whenPageIsLoaded(String page) {
        subSteps.stepPageIsLoaded(page);
    }
}
