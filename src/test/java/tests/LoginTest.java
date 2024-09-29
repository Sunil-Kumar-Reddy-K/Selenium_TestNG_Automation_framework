package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        // Access the LoginPage via the getter in BaseTest
        getLoginPage().navigateToTheUrl();
        getLoginPage().enterUsername("Admin");
        getLoginPage().enterPassword("admin123");
        getLoginPage().clickLogin();

        // You can now proceed with assertions or other steps
    }
}
