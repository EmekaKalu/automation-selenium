package Base;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public abstract class TestBase {

    public static WebDriver driver;
    protected static LoginPage loginPage;
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    String website = dotenv.get("SAUCE_URL");

    @Parameters({"BrowserName","BrowserVersion","Platform"})
    @BeforeTest(alwaysRun = true)
    public void SetUp(String BrowserName, String BrowserVersion, String Platform){
        System.out.println("BrowserName: " + BrowserName);
        System.out.println("BrowserVersion: " + BrowserVersion);
        System.out.println("Platform: " + Platform);

       if (BrowserName.equalsIgnoreCase("Chrome")) {
           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           driver = new ChromeDriver(options);
           driver.manage().deleteAllCookies();
           System.out.println("Running on Chrome Browser");
       }

        System.out.println("navigating to " + website);
        if (driver != null) { // Check for null driver before using it
            driver.get(website);
            System.out.println("navigated to " + website);
        } else {
            System.out.println("Failed to initialize driver for " + BrowserName);
            // Handle the case where driver initialization fails (e.g., log an error)
        }
    }


    @AfterTest(alwaysRun = true)
    public void Quit(){
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Test finished");
    }
}
