package nazarov.stetsyuk.pages;

import nazarov.stetsyuk.controllers.Button;
import nazarov.stetsyuk.controllers.TextInput;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class TestPage extends BasePage {

    @FindBy(xpath = "//input[@class='input__control input__input']")
    TextInput Search_Input;

    @FindBy(xpath = "//button[contains(@class,'button suggest2')]")
    Button Search_Button;

}
