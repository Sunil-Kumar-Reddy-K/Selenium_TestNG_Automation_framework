package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LoginPage;
//import pages.HomePage;

public class BaseTest {

    // ThreadLocal Page Objects
    private static ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();
//    private static ThreadLocal<HomePage> homePage = new ThreadLocal<>();

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        // Initialize WebDriver based on the browser
        DriverFactory.setDriver(browser);

        // Initialize Page Objects
        loginPage.set(new LoginPage(DriverFactory.getDriver()));
//        homePage.set(new HomePage(DriverFactory.getDriver()));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Getter methods for Page Objects
    public static LoginPage getLoginPage() {
        return loginPage.get();
    }

 /*   public static HomePage getHomePage() {
        return homePage.get();
    }*/
}
