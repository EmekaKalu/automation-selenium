package Helpers;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil extends TestBase {

    public JavaScriptUtil(WebDriver driver) {
        TestBase.driver = driver;
    }

    public static void DoScrollIntoView(WebElement locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", locator);
    }

    public static void DoClick(WebElement locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", locator);
    }


}
