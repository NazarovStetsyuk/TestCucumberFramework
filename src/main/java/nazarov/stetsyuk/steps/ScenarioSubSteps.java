package nazarov.stetsyuk.steps;

import nazarov.stetsyuk.controllers.Element;
import nazarov.stetsyuk.hooks.Hooks;
import nazarov.stetsyuk.pages.BasePage;
import org.reflections.Reflections;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Set;

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

    @Step("Загружена страница \"pageName\"")
    public void stepPageIsLoaded(String pageName){
        Reflections reflections = new Reflections("nazarov.stetsyuk.pages");
        Set<Class<? extends BasePage>> allPages = reflections.getSubTypesOf(BasePage.class);

        for (Class<? extends BasePage> currentPage : allPages) {
            if (currentPage.getName().endsWith("." + pageName)){
                try{
                    BasePage page = currentPage.getConstructor().newInstance();
                    page.initialize(Hooks.getDriver());
                    BasePage.currentPage = page;
                    return;
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
