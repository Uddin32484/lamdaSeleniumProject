package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  extends BaseTest {
   public WebDriver driver;

    private final By simpleFormDemoLink = By.linkText("Simple Form Demo");


    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSimpleFormDemo() {
        driver.findElement(simpleFormDemoLink).click();
    }

    public void clickLinkByText(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @FindBy(linkText = "Input Form Submit")
    private WebElement inputFormSubmitLink;

//     @FindBy(xpath ="//a[contains(text(),'Input Form Submit')]")
//     private WebElement inputFormSubmitLink;

    public void navigateToHomePage() {
        driver.get("https://www.lambdatest.com/selenium-playground");
    }

    public HomePage clickInputFormSubmit() {
        clickElement(inputFormSubmitLink);
        return new HomePage(driver);

    }

    private void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.err.println("Failed to click element: " + e.getMessage());
            throw e;
        }
    }


}
