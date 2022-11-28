package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod02Test {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.LOGIN_FORM_SLUG));

            // Input login creds
            LoginPageMod02 loginPage = new LoginPageMod02(driver);
            loginPage.inputUsername("Teo");
            loginPage.inputPassword("123456");
            loginPage.clickButton();

            // Debug only
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }
}
