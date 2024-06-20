import Base.TestBase;
import Pages.LoginPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login extends TestBase {

    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    String valid_username = dotenv.get("SAUCE_USERNAME");
    String valid_password = dotenv.get("SAUCE_PASSWORD");

    @BeforeMethod
    public void pageObject() {
         loginPage = new LoginPage(driver);
    }


    @Test(priority = 1)
    public void valid_login_Test() throws Exception {
        System.out.println("Logging in");
        loginPage.valid_login(valid_username, valid_password);
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
