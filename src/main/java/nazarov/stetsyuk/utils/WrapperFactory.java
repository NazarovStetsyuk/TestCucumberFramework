package nazarov.stetsyuk.utils;

import nazarov.stetsyuk.controllers.Element;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class WrapperFactory {

    /**
     *  Создает экземпляр класса,
     *  реализующий интерфейс Element
     *  вызывая конструктор с аргументом WebElement
     */
    public static Element createInstance(Class<Element> clazz, WebElement element){
        try{
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e){
            throw new AssertionError("Web element can not be represented as " + clazz);
        }
    }
}
