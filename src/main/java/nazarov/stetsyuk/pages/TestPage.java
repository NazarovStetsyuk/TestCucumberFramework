package nazarov.stetsyuk.pages;

import nazarov.stetsyuk.controllers.Button;
import nazarov.stetsyuk.controllers.TextInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class TestPage extends BasePage {

    @FindBy(xpath = "//input[@class='input__control input__input']")
    TextInput Search_Input;

    @FindBy(xpath = "//button[@class='button suggest2-form__button button_theme_websearch button_size_ws-head i-bem button_js_inited']")
    Button Search_Button;

}
