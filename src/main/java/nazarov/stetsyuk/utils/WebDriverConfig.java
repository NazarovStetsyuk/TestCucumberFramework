package nazarov.stetsyuk.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.File;

public class WebDriverConfig {

    public static WebDriver setChromeProfile() {

        File pathToBinary = new File("C:\\Program Files (x86)\\");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        WebDriver driver = WebDriverFactory.getDriver(capabilities);
        return driver;
    }
}
