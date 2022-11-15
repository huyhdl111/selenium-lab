package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class IFrame {
    public static void main(String[] args) {
        // iframe[id^="mce"]

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.IFRAME_SLUG));

            // Locate iframe
            WebElement iFrameElem = driver.findElement(By.cssSelector("iframe[id^='mce']"));

            // Switch to the iframe
            driver.switchTo().frame(iFrameElem);

            // Input text to the input text area
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("The is the new value......\n And this is the new line");

            // Switch to the parent page
            driver.switchTo().defaultContent();
            System.out.println(driver.findElement(By.partialLinkText("Selenium")).getAttribute("href"));

            // Debug purpose only
            Thread.sleep(2000);
            driver.quit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
