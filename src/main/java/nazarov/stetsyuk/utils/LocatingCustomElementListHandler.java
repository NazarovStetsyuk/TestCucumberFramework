package nazarov.stetsyuk.utils;

import nazarov.stetsyuk.controllers.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class LocatingCustomElementListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class<Element> clazz;

    public LocatingCustomElementListHandler(ElementLocator locator, Class<Element> clazz){
        this.locator = locator;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        // Находит список WebElement и обрабатывает каждый его элемент
        // Возвращает новый список с элементами кастомного класса
        List<WebElement> elements = locator.findElements();
        List<Element> customs = new ArrayList<>();

        for (WebElement element : elements) {
            customs.add(WrapperFactory.createInstance(clazz, element));
        }
        try {
            return method.invoke(customs, object);
        } catch (InvocationTargetException e){
            throw e.getCause();
        }
    }
}
