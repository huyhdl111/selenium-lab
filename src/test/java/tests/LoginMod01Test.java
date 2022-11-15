package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod01Test {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(Urls.BASE_URL.concat(Urls.LOGIN_FORM_SLUG));

            // Input login creds
            LoginPageMod01 loginPage = new LoginPageMod01(driver);
            loginPage.usernameElem().sendKeys("Teo");
            loginPage.passwordElem().sendKeys("234567");
            loginPage.loginBtnElem().click();

            // Debug only
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }
}
