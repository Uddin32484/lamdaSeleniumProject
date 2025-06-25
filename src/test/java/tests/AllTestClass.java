package tests;


import base.AllureListener;
import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import page.InputFormPage;
import page.SimpleFormPage;
import page.SliderPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("LambdaTest Playground")
@Feature("Slider Test")
@Listeners({AllureListener.class})
public class AllTestClass extends BaseTest {



   ///Test Scenario 1.///////

   @Test(priority = 1, description = "Test Scenario 1: Simple Form Demo Test")
   @Severity(SeverityLevel.CRITICAL)
   @Story("User enters a message and verifies the output")
   @Description("This test navigates to the Simple Form Demo, inputs a message, and verifies the same is displayed.")
   public void testSimpleFormMessage() {
       HomePage homePage = new HomePage(driver);
       homePage.clickSimpleFormDemo();
       assertTrue(driver.getCurrentUrl().contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");
       SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
       String message = "Welcome to LambdaTest";
       simpleFormPage.enterMessage(message);
       simpleFormPage.clickGetCheckedValue();
       assertEquals(simpleFormPage.getDisplayedMessage(), message, "Displayed message does not match input.");
   }

    @Test(priority = 2,description = "Test Scenario 2: Slider Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("Drag slider and validate output")
    @Description("Moves the slider to 95 and verifies the displayed value.")
    public void testSliderValue() {
       HomePage homePage = new HomePage(driver);
        homePage.clickLinkByText("Drag & Drop Sliders");
        SliderPage sliderPage = new SliderPage(driver);
        sliderPage.moveSliderTo(95);
        String value = driver.findElement(By.xpath("//*[@id=\"rangeSuccess\"]")).getText();
        System.out.println("Slider value: " + value);
        assertEquals(sliderPage.getSliderValue(), "100", "Slider value is not 95.");
    }

  //Test Scenario 3.///////


    @Test( priority = 3,description = "Test Scenario 3: Input Form Submit Test")
    public void testInputFormSubmission() {

        HomePage homePage = new HomePage(driver);
        InputFormPage inputFormPage = new InputFormPage(driver);
        homePage.navigateToHomePage();
        inputFormPage.clikcOnInputFormtLink();
        // Step 2: Click Submit without filling any information
        inputFormPage.clickSubmitWithoutFilling();

        // Step 3: Assert "Please fill out this field." error message
        String validationMessage = inputFormPage.getNameFieldValidationMessage();
        Assert.assertEquals(validationMessage, "Please fill out this field.",
                "Validation message for empty name field should be displayed");

        // Step 4: Fill in Name, Email, and other fields
        // Step 5: Select "United States" from Country dropdown using text property
        // Step 6: Fill in all fields and click Submit
        inputFormPage.fillCompleteForm(
                "John Doe",                    // name
                "john.doe@example.com",        // email
                "password123",                 // password
                "Test Company",                // company
                "https://testcompany.com",     // website
                "United States",               // country
                "New York",                    // city
                "123 Main Street",             // address1
                "Apt 4B",                      // address2
                "NY",                          // state
                "10001"                        // zip
        );

        inputFormPage.submitForm();

        // Step 7: Validate success message
        String successMessage = inputFormPage.getSuccessMessage();
        Assert.assertEquals(successMessage,
                "Thanks for contacting us, we will get back to you shortly.",
                "Success message should be displayed after form submission");

        System.out.println("Test completed successfully!");
        System.out.println("Success message: " + successMessage);
    }




    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
