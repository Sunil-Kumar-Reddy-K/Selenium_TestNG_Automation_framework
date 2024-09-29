package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebDriverUtils {

    // Method to capture a screenshot
    public static String takeScreenshot(WebDriver driver, String testName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "reports/screenshots/" + testName + ".png";
        Files.copy(srcFile.toPath(), Paths.get(destPath));
        return destPath;
    }
}
