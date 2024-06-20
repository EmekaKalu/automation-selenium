package Pages;

import Base.TestBase;
import Helpers.JavaScriptUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends TestBase {

    JavaScriptUtil javascriptUtil;

    @FindBy(id = "user-name")
    @CacheLookup
    WebElement username;

    @FindBy(id = "password")
    @CacheLookup
    WebElement password;

    @FindBy(id = "login-button")
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    @CacheLookup
    public WebElement loginFailedText;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    @CacheLookup
    public WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    @CacheLookup
    WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        javascriptUtil = new JavaScriptUtil(driver);
    }

    public void loginFailedText() {
        String $error = loginFailedText.getText();
        Assert.assertEquals($error, "Epic sadface: Username and password do not match any user in this service");
    }

    public void valid_login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        loginButton.click();
    }

    public void invalid_login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        loginButton.click();
        loginFailedText();

    }

    public void logout() throws InterruptedException {
        JavaScriptUtil.DoClick(menuButton);
        Thread.sleep(5000);
        JavaScriptUtil.DoScrollIntoView(logoutButton);
        logoutButton.click();
    }
}
