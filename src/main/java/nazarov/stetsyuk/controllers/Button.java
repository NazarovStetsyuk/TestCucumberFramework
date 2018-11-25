package nazarov.stetsyuk.controllers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(WebElement element) { super(element); }

    @Override
    public void click(){
        if (isEnable()) element.click();
        else throw new NoSuchElementException("Element is disable: " + element);
    }

    @Override
    public String getText(String value) {
        return value;
    }

    @Override
    public void setValue(String value) {
        System.out.println("Ничего");
    }
}
