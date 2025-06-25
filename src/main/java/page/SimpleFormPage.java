package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormPage {
    WebDriver driver;
    private By messageInput = By.id("user-message");
    private By showMessageBtn = By.id("showInput");
    private By displayedMessage = By.id("message");

    public SimpleFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickShowMessage() {
        driver.findElement(showMessageBtn).click();
    }
    public void clickGetCheckedValue() {
        driver.findElement(showMessageBtn).click();
    }

    public String getDisplayedMessage() {
        return driver.findElement(displayedMessage).getText();
    }
}
