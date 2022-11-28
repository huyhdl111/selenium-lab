package tests;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.HerokuLoginPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.LOGIN_FORM_SLUG));

            // Input login creds
            HerokuLoginPage loginPage = new HerokuLoginPage(driver);
            //System.out.println(loginPage.footerComponent().getLinkText());

            LoginFormComponent loginFormComp = loginPage.loginFormComponent();
            loginFormComp.usernameElem().sendKeys("Teo");

            // Debug only
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }
}
