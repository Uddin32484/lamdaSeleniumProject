package page;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputFormPage extends BaseTest {
    final WebDriver driver;
    public InputFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//a[contains(text(),'Input Form Submit')]")
    private WebElement inputFormSubmitLink;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "inputEmail4")
    private WebElement emailField;

    @FindBy(id = "inputPassword4")
    private WebElement passwordField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "websitename")
    private WebElement websiteField;

    @FindBy(name = "country")
    private WebElement countryDropdown;

    @FindBy(id = "inputCity")
    private WebElement cityField;

    @FindBy(id = "inputAddress1")
    private WebElement address1Field;

    @FindBy(id = "inputAddress2")
    private WebElement address2Field;

    @FindBy(id = "inputState")
    private WebElement stateField;

    @FindBy(id = "inputZip")
    private WebElement zipField;

    @FindBy(xpath = "//*[@id=\"seleniumform\"]/div[6]/button")
    private WebElement formSubmitButton;

    @FindBy(xpath = "//p[@class='success-msg hidden']")
    private WebElement successMessage;



     public  void clikcOnInputFormtLink() {
         inputFormSubmitLink.click();
         new WebDriverWait(driver, Duration.ofSeconds(10))
                 .until(ExpectedConditions.visibilityOf(nameField));
     }
    public void fillName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void fillEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void fillCompany(String company) {
        companyField.clear();
        companyField.sendKeys(company);
    }

    public void fillWebsite(String website) {
        websiteField.clear();
        websiteField.sendKeys(website);
    }

    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void fillCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void fillAddress1(String address) {
        address1Field.clear();
        address1Field.sendKeys(address);
    }

    public void fillAddress2(String address) {
        address2Field.clear();
        address2Field.sendKeys(address);
    }

    public void fillState(String state) {
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void fillZip(String zip) {
        zipField.clear();
        zipField.sendKeys(zip);
    }

    public void fillCompleteForm(String name, String email, String password,
                                 String company, String website, String country,
                                 String city, String address1, String address2,
                                 String state, String zip) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        fillCompany(company);
        fillWebsite(website);
        selectCountry(country);
        fillCity(city);
        fillAddress1(address1);
        fillAddress2(address2);
        fillState(state);
        fillZip(zip);
    }



    public void submitForm() {
        formSubmitButton.click();
    }

    public void clickSubmitWithoutFilling() {
        formSubmitButton.click();
    }

    public String getNameFieldValidationMessage() {
        return nameField.getAttribute("validationMessage");
    }

    public String getSuccessMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }
}
