package nazarov.stetsyuk.utils;

import nazarov.stetsyuk.controllers.Element;
import nazarov.stetsyuk.pages.BasePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.Proxy;
import java.util.List;

@Component
public class CustomFieldDecorator extends DefaultFieldDecorator {

    BasePage page;

    public CustomFieldDecorator(BasePage page, SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
        this.page = page;
    }

    /**
     *  Метод вызывается фабрикой для каждого поля в классе
     */
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<Element> decoratableClass = decoratableClass(field);
        // Если класс поля декорируемый
        if(decoratableClass != null){
            ElementLocator locator = factory.createLocator(field);
            if(locator == null) return null;
            if (List.class.isAssignableFrom(field.getType())) return createList(loader, locator, decoratableClass);
            Element element = createElement(loader, locator, decoratableClass);
            page.getElements().add(element);
            return element;
        }
        return super.decorate(loader, field);
    }

    /**
     * Возвращает декорируемый класс поля,
     * либо null, если класс не подходит для декоратора
     */

    private Class<Element> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        if (List.class.isAssignableFrom(clazz)) {
            // Для списка должна быть задана аннотация
            if (field.getAnnotation(FindBy.class) == null &&
                    field.getAnnotation(FindBys.class) == null) {
                return null;
            }

            // Список должен быть параметризован
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }

            // Получаем класс для элементов списка
            clazz = (Class<?>)((ParameterizedType) genericType).getActualTypeArguments()[0];
        }

        if (Element.class.isAssignableFrom(clazz)) {
            return (Class<Element>) clazz;
        } else return null;
    }


    /**
     * Создание элемента.
     * Находит WebElement и передает его в кастомный класс
     */
    protected Element createElement(ClassLoader loader, ElementLocator locator, Class<Element> clazz){
        InvocationHandler handler = new LocatingCustomElementListHandler(locator, clazz);
        WebElement proxy = proxyForLocator(loader, locator);
        return WrapperFactory.createInstance(clazz, proxy);
    }

    /**
     * Создание списка
     */
    protected List<Element> createList(ClassLoader loader, ElementLocator locator, Class<Element> clazz) {
        InvocationHandler handler = new LocatingCustomElementListHandler(locator, clazz);
        List<Element> elements = (List<Element>) Proxy.newProxyInstance(loader, new Class[] {List.class}, handler);
        return elements;
    }


}
