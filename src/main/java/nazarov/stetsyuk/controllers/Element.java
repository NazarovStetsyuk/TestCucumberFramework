package nazarov.stetsyuk.controllers;

import org.openqa.selenium.WebElement;

public interface Element{

    String getText();

    void setValue(String value);

    void click();
}
