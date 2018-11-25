package nazarov.stetsyuk.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nazarov.stetsyuk.utils.TestProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

    protected static WebDriver driver;
    public static TestProperties properties = TestProperties.getInstance();
    protected static String baseURL;


    public static WebDriver getDriver() {
        return driver;
    }

    public Hooks() {
        PageFactory.initElements(getDriver(), this);
    }

    @Before
    public static void startScenario() {

        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();

        baseURL = properties.getProperty("app.url");
        System.out.print(baseURL);

        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("implicityWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("pageLoad")), TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(baseURL + "/");
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
