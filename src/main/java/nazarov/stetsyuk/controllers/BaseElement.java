package nazarov.stetsyuk.controllers;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public abstract class BaseElement implements Element{

    protected WebElement element;

    public BaseElement(WebElement element) { this.element = element; }

    public  WebElement getWebElement() { return element; }

    public boolean isEnable() {
        if(isVisible()) return element.isEnabled();
        else  throw new ElementNotVisibleException("Element is not visible: " + element);
    }

    public boolean isVisible(){
        try {
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void click(){
        if (isEnable()) element.click();
        else throw new NoSuchElementException("Element is disable: " + element);
    }

    public String getText() {
        return this.getText();
    }
}
