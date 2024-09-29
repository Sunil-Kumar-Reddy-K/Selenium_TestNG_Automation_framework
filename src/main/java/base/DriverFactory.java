package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // ThreadLocal for WebDriver to ensure parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to initialize WebDriver based on the browser
    public static WebDriver setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        return driver.get();
    }

    // Get the WebDriver instance for the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit the WebDriver instance for the current thread
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
