package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class FormInteractionMultipleMatching {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector values
            By inputFieldSel = By.tagName("input_taolao");
            //WebElement usernameElem = driver.findElement(inputFieldSel);
            List<WebElement> inputFieldsElem = driver.findElements(inputFieldSel);
            if (inputFieldsElem.isEmpty()){
                throw new RuntimeException("[ERR] There is no input fields");
            }
            inputFieldsElem.get(0).sendKeys("Teo");
            inputFieldsElem.get(1).sendKeys("123456");

            // Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
