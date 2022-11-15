package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import url.Urls;

import java.time.Duration;

public class JsAlert {

    private final static By jsAlertSel = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private final static By resultTextSel = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(Urls.BASE_URL.concat(Urls.JS_ALERT_SLUG));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            Boolean isAccepted = true;
            // Js Alert | Ok
            WebElement triggerJsAlertBtnElem = driver.findElement(jsAlertSel);
            handleAlert(wait, triggerJsAlertBtnElem, isAccepted);
            System.out.println(driver.findElement(resultTextSel).getText());

            // Js Confirm | Cancel
            WebElement triggerJsConfirmBtnElem = driver.findElement(jsConfirmSel);
            isAccepted = false;
            handleAlert(wait, triggerJsConfirmBtnElem, isAccepted);
            System.out.println(driver.findElement(resultTextSel).getText());

            // Js Prompt | Input text then ok
            WebElement triggerJsPromptBtnElem = driver.findElement(jsPromptSel);
            handleAlert(wait, triggerJsPromptBtnElem, "My name is Teo");
            System.out.println(driver.findElement(resultTextSel).getText());

            // TODO: Create a common method

        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

    private static void handleAlert(WebDriverWait wait, WebElement alertElem, boolean isAccepted){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (isAccepted){
            alert.accept();
        } else alert.dismiss();
    }

    private static void handleAlert(WebDriverWait wait, WebElement alertElem, String inputStr){
        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(inputStr);
        alert.accept();
    }

}
