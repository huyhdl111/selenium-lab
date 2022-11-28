package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import java.time.Duration;

public class Dynamic_Control {
    public static void main(String[] args) {
        WebDriver drive = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            drive.get(Urls.HEROKU_BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));

            // Define 2 form locator
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");

            // Interact with the checkbox form elems
            WebElement checkboxFormElem = drive.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));

            // If the checkbox is not selected then select it
            if (!checkboxElem.isSelected()) {
                checkboxElem.click();
            }
            // Debug purpose only
            Thread.sleep(1000);

            // Interact with the input form elems
            WebElement inputFormElem = drive.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputButtonElem = inputFormElem.findElement(By.tagName("button"));
            // If the text field is not enabled then click on the button
            if (!inputFieldElem.isEnabled()) {
                inputButtonElem.click();
                // Wait until the text field is enable then send keys
                WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(20L));
                wait.until(new WaitForElementEnabled(By.cssSelector("#input-example input")));
            }
            inputFieldElem.sendKeys("This is the new text");

            // Debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        drive.quit();
    }
}
