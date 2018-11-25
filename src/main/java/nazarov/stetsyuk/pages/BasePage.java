package nazarov.stetsyuk.pages;

import nazarov.stetsyuk.controllers.Element;
import nazarov.stetsyuk.utils.CustomFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class BasePage implements InitializingBean {

    public static BasePage currentPage;
    static WebDriver driver;
    private List<Element> elements = new ArrayList<>();

    @PostConstruct
    public void customInit() {
        System.out.println("Method customInit invoked...");
    }


    public List<Element> getElements() {
        return elements;
    }

    public void setElements() {
        this.elements = elements;
    }

    public Element getFieldSafe(String fieldName) {
        Object object = null;
        try {
            object = getField(fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (object instanceof Element) {
            return (Element) object;
        } else {
            throw new RuntimeException(String.format("Object '%s' of Class '%s' is not an instance of TypifiedElement",fieldName,object.getClass()));
        }
    }

    public Object getField(String fieldName) throws Exception {
        return (getClass().getDeclaredField(fieldName).get(this));
    }

    public void initialize(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(this, driver), this);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        customInit();
    }
}
