package base;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.HashMap;

@Getter
public class BaseTest {

    protected WebDriver driver;

    @Parameters({"platform", "browser", "version"})
    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName(ConfigReader.get("lt.platform"));
        browserOptions.setBrowserVersion(ConfigReader.get("lt.version"));

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", ConfigReader.get("lt.username"));
        ltOptions.put("accessKey", ConfigReader.get("lt.accessKey"));
// other options...

        browserOptions.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(
                new URL(ConfigReader.get("lt.url")),
                browserOptions

        );
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }







    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}