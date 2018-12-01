package nazarov.stetsyuk.controllers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TextInput extends BaseElement {

    public TextInput(WebElement element) {
        super(element);
    }

    public void setValue(String value){
        if (isEnable()){
            try{
                clearText();
                click();
                element.sendKeys(value);
            } catch (NoSuchElementException e) {
                e.getLocalizedMessage();
            }
        } else throw new NoSuchElementException("Element is disable: " + element);
    }

    public void clearText() {
        if (isEnable()){
            element.clear();
        }
    }
}
