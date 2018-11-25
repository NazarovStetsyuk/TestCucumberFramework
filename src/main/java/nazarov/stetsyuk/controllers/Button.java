package nazarov.stetsyuk.controllers;

import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(WebElement element) {
        super(element);
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
