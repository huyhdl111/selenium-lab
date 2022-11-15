package api_learning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageHelper {

    private final static String SCROLL_TO_BOTTOM_SCRIPT = "window.scrollTo(0, document.body.scrollHeight)";
    private final static String SCROLL_TO_TOP_SCRIPT = "window.scrollTo(document.body.scrollHeight, 0)";

    private final JavascriptExecutor jsExcutor;

    public PageHelper(JavascriptExecutor jsExcutor) {
        this.jsExcutor = jsExcutor;
    }

    public void scrollToBottom(){
        jsExcutor.executeScript(SCROLL_TO_BOTTOM_SCRIPT);
    }

    public void scrollToTop(){
        jsExcutor.executeScript(SCROLL_TO_TOP_SCRIPT);
    }

    public void removeElement(WebElement toBeRemoveElem){
        jsExcutor.executeScript("arguments[0].remove()", toBeRemoveElem);
    }

    public void changeElemStyleToFocusMode(WebElement toBeChangeElem){
        jsExcutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px red;')", toBeChangeElem);
    }

    public void changeElemStyleToFocusMode(WebElement toBeChangeElem, String customStyle){

    }
}
