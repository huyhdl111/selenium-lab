package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class JsExcutor {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.FLOATING_MENU_SLUG));
            JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
            PageHelper pageHelper = new PageHelper(jsExcutor);

            // Scroll to bottom
            pageHelper.scrollToBottom();

            // Debug only
            Thread.sleep(2000);

            //Scroll to top
            pageHelper.scrollToTop();

            // Debug only
            Thread.sleep(2000);

            // Go to Dynamic Control page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement inputFormElem = driver.findElement(inputFormSel);
            pageHelper.removeElement(inputFormElem);
            pageHelper.changeElemStyleToFocusMode(checkboxFormElem);

            // Debug only
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
