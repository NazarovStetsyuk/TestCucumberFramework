package nazarov.stetsyuk.hooks;

import nazarov.stetsyuk.utils.TestProperties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

    protected static WebDriver driver;
    public static TestProperties properties = TestProperties.getInstance();
    protected static String baseURL;


    public static WebDriver getDriver() { return driver; }

    public Hooks(){ PageFactory.initElements(getDriver(), this); }

    @Before
    public static void startScenario(){
        switch (properties.getProperty("browser")){
            case "chrome":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new ChromeDriver();
        }

        baseURL = properties.getProperty("app.url");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("implicityWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("pageLoad")), TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(baseURL + "/");
    }

    @After
    public static void tearDown() throws Exception{
        driver.quit();
    }
}
