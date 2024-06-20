import Base.TestBase;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login extends TestBase {

    @BeforeMethod
    public void pageObject() {
         loginPage = new LoginPage(driver);
    }

//    @AfterMethod(alwaysRun = true)
//    public void logout() {
//        System.out.println("Attempting to logout");
//        if (loginPage.menuButton.isDisplayed()){
//            System.out.println("Logging out");
//            loginPage.logout();
//        } else {
//            System.out.println("Already logged out");
//        }
//    }

    @Test(priority = 1)
    public void valid_login_Test() throws Exception {
        System.out.println("Logging in");
        loginPage.valid_login("standard_user", "secret_sauce");
        System.out.println("Logged in");
    }

    @Test(priority = 2)
    public void logout_Test() throws Exception {
        System.out.println("Logging out");
        loginPage.logout();
        System.out.println("Logged out");
    }

    @Test(priority = 3)
    public void invalid_login_Test() throws Exception {
        System.out.println("Logging in");
        loginPage.invalid_login("standard_user", "invalid_password");
        Thread.sleep(3000);
        System.out.println("Login Failed");
    }

}
