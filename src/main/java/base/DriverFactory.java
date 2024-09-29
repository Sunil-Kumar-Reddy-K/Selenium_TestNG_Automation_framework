package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // ThreadLocal for WebDriver to ensure parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to initialize WebDriver based on the browser and environment (headless for CI)
    public static WebDriver setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();

            // Check if running in CI (headless mode)
            if (System.getenv("CI") != null) {
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
            }

            driver.set(new ChromeDriver(chromeOptions));

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            // Check if running in CI (headless mode)
            if (System.getenv("CI") != null) {
                firefoxOptions.addArguments("--headless");
            }

            driver.set(new FirefoxDriver(firefoxOptions));
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
