package tests;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import url.Urls;

public class DemoHomePageTest {

    @Test
    public void testFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(Urls.BASE_URL);

            HomePage homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComponent();
            InformationColumn informationColumn = footerComponent.informationColumn();
            CustomerServiceColumn customerServiceColumn = footerComponent.customerServiceColumn();
            MyAccountColumn myAccountColumn = footerComponent.myAccountColumn();
            FollowUsColumn followUsColumn = footerComponent.followUsColumn();

            System.out.println(informationColumn.headerElem().getText());
            System.out.println(customerServiceColumn.headerElem().getText());
            System.out.println(myAccountColumn.headerElem().getText());
            System.out.println(followUsColumn.headerElem().getText());

            // Debug only
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }
}
