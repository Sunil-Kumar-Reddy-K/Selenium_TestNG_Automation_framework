package utils;

import base.DriverFactory;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Setting up ExtentSparkReporter
    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite finished!");
        extent.flush(); // Write the report to disk
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Capture screenshot on failure using DriverFactory's getDriver() method
        try {
            String screenshotPath = WebDriverUtils.takeScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            extentTest.get().log(Status.FAIL, "Failed to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }
}
