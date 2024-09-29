package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChromeLaunchTest {
    public static void main(String[] args) {
        // Set up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Now you can create the ChromeDriver instance without setting the path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title is: " + driver.getTitle());

        // Clean up
        driver.quit();
    }
}
