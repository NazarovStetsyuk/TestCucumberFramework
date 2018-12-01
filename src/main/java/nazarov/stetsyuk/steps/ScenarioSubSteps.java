package nazarov.stetsyuk.steps;

import nazarov.stetsyuk.controllers.Element;
import nazarov.stetsyuk.hooks.Hooks;
import nazarov.stetsyuk.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.reflections.Reflections;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Set;

import static java.lang.Thread.sleep;

public class ScenarioSubSteps {

    @Step
    public void stepFieldIsClicked(String fieldName) {
        Element webElement = (Element) BasePage.currentPage.getFieldSafe(fieldName);
        webElement.click();
    }

    @Step
    public void stepFieldIsFilledWithValue(String fieldName, String value) {
        Element webElement = (Element) BasePage.currentPage.getFieldSafe(fieldName);
        webElement.setValue(value);
    }

    @Step
    public void stepMoveCursorToField(String fieldName) {

        Actions action = new Actions(Hooks.getDriver());
        Element webElement = (Element) BasePage.currentPage.getFieldSafe(fieldName);
        action.moveToElement((WebElement) webElement).build().perform();
        try {
            sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Загружена страница \"pageName\"")
    public void stepPageIsLoaded(String pageName) {
        Reflections reflections = new Reflections("nazarov.stetsyuk.pages");
        Set<Class<? extends BasePage>> allPages = reflections.getSubTypesOf(BasePage.class);

        for (Class<? extends BasePage> currentPage : allPages) {
            if (currentPage.getName().endsWith("." + pageName)) {
                try {
                    BasePage page = currentPage.getConstructor().newInstance();
                    page.initialize(Hooks.getDriver());
                    BasePage.currentPage = page;
                    return;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
