package nazarov.stetsyuk.controllers;

import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(WebElement element) {
        super(element);
    }

    @Override
    public void setValue(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getText(String value) {
        return null;
    }
}
