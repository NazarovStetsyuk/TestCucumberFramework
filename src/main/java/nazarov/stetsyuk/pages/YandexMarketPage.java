package nazarov.stetsyuk.pages;

import nazarov.stetsyuk.controllers.Button;
import nazarov.stetsyuk.controllers.TextInput;
import org.openqa.selenium.support.FindBy;

import javax.security.auth.callback.TextInputCallback;

/**
 * Created by Иванка on 01.12.2018.
 */
public class YandexMarketPage extends BasePage{

    @FindBy(xpath = "//input[@id='header-search']")
    TextInput Search_Input;

    @FindBy(xpath = "//span[@class='suggest2-form__node']//button")
    Button Find_Button;

    @FindBy(xpath = "//div[contains(@class,'n-snippet-list')]/div[contains(@class,'n-snippet-cell')]")
    Button Element_Element;
}
