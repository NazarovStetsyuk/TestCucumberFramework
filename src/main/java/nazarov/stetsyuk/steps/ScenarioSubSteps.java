package nazarov.stetsyuk.steps;

import nazarov.stetsyuk.hooks.Hooks;
import nazarov.stetsyuk.pages.BasePage;
import org.reflections.Reflections;
import ru.yandex.qatools.allure.annotations.Step;
import sun.reflect.Reflection;

import java.util.Set;

public class ScenarioSubSteps {

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
