package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMod01 {

    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static By loginButtonSel = By.cssSelector("button[type='submit']");
    private final WebDriver driver;

    public LoginPageMod01(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameElem(){
        return driver.findElement(usernameSel);
    }

    public WebElement passwordElem(){
        return driver.findElement(passwordSel);
    }

    public WebElement loginBtnElem(){
        return driver.findElement(loginButtonSel);
    }

}
