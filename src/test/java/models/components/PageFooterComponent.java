package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#page-footer")
public class PageFooterComponent extends Component{
    public PageFooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    private static final By linktext = By.tagName("a");

    public String getLinkText(){
        return component.findElement(linktext).getText();
    }


}
