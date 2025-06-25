package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class SliderPage {
    private WebDriver driver;
    private By slider = By.xpath("//input[@value='15']");
    private By sliderValue = By.id("rangeSuccess");

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSliderTo(int targetValue) {
        WebElement sliderElement = driver.findElement(slider);
        Actions actions = new Actions(driver);
        int width = sliderElement.getSize().width;
        int xOffset = (int) ((targetValue - 15) * (width / 100.0)); // Basic calculation
        actions.clickAndHold(sliderElement).moveByOffset(xOffset, 1).release().perform();
    }

//    public void moveSliderTo(int targetValue) {
//        WebElement sliderElement = driver.findElement(slider);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Define the range: min=15, max=95
//        int minValue = 15;
//        int maxValue = 95;
//
//        if(targetValue < minValue || targetValue > maxValue) {
//            throw new IllegalArgumentException("Target value should be between 15 and 95");
//        }
//
//        // Use JavaScript to set the slider value directly
//        // This approach bypasses the UI interaction and sets the value programmatically
////        String script = "arguments[0].value = " + targetValue + ";" +
////                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
////                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));";
//
//        // Method 3: Set properties directly and trigger React/Angular events
//        String reactScript =
//                "var slider = arguments[0];" +
//                        "var targetValue = " + targetValue + ";" +
//
//                        // Set value properties
//                        "slider.value = targetValue;" +
//                        "slider.setAttribute('value', targetValue);" +
//
//                        // For React components
//                        "if (slider._valueTracker) {" +
//                        "  slider._valueTracker.setValue(targetValue.toString());" +
//                        "}" +
//
//                        // Create and dispatch events that React/Angular listen for
//                        "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
//                        "nativeInputValueSetter.call(slider, targetValue);" +
//
//                        // Dispatch input event that React recognizes
//                        "var inputEvent = new Event('input', { bubbles: true });" +
//                        "slider.dispatchEvent(inputEvent);" +
//
//                        // Additional events
//                        "var changeEvent = new Event('change', { bubbles: true });" +
//                        "slider.dispatchEvent(changeEvent);";
//
//        js.executeScript( reactScript, sliderElement);
//        String currentValue = sliderElement.getAttribute("value");
//        System.out.println("Current slider value: " + currentValue);
//
//
//    }



    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }

}