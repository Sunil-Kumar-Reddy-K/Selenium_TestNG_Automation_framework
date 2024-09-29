# Selenium Automation Framework

This is a Selenium automation framework designed for UI testing with support for multiple browsers, parallel test execution, Cucumber integration, TestNG, Extent Reports, and GitHub Actions for CI/CD.

## Framework Features
- **Driver Factory**: Centralized WebDriver management for different browsers.
- **Page Object Model (POM)**: Clean structure for page-specific actions and locators.
- **Cucumber Integration**: Behavior-driven testing with feature files.
- **TestNG**: Test execution framework supporting parallel testing.
- **Extent Reports**: Beautiful, detailed reports of test executions.
- **Multi-browser Support**: Test against multiple browsers like Chrome and Firefox.
- **Parallel Execution**: Speed up test runs by running them in parallel.
- **Listeners**: TestNG listeners for capturing logs, screenshots, and generating reports.

---

## (Implemented) TestNG framework folder structure
SeleniumAutomationFramework/
├── pom.xml                           # Maven dependency management
├── testng.xml                         # TestNG suite configuration
├── config.properties                  # Config file for environment variables
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BaseTest.java      # Base class for WebDriver and setup
│   │   │   │   ├── DriverFactory.java # WebDriver initialization and management
│   │   │   │
│   │   │   ├── pages/                 # Page Object Model classes
│   │   │   │   ├── LoginPage.java     # POM class for Login functionality
│   │   │   │   └── HomePage.java      # POM class for Home Page functionality
│   │   │   │
│   │   │   ├── utils/                 # Utility classes and helpers
│   │   │   │   ├── ConfigReader.java  # Reads from config.properties
│   │   │   │   ├── ExtentManager.java # ExtentReports setup
│   │   │   │   ├── TestListener.java  # TestNG listeners for logging and reports
│   │   │   │   └── WebDriverUtils.java # Additional WebDriver helper functions
│   │   │
│   └── resources/
│       ├── extent-config.xml          # Config file for ExtentReports customization
│       └── config.properties          # Configuration file for test data/environment
│
├── src/test/
│   ├── java/
│   │   ├── tests/                     # TestNG test classes
│   │   │   └── LoginTest.java         # TestNG test class for Login functionality
│
├── reports/                           # Extent reports and logs generated from tests
│   └── extent-reports/                # Folder to store the Extent report files


## (Example) Cucumber Framework Folder Structure

SeleniumAutomationFramework/
├── pom.xml                           # Maven dependency management
├── testng.xml                         # TestNG suite configuration
├── config.properties                  # Config file for environment variables
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BaseTest.java      # Base class for WebDriver and setup
│   │   │   │   ├── DriverFactory.java # WebDriver initialization and management
│   │   │   │
│   │   │   ├── pages/                 # Page Object Model classes
│   │   │   │   ├── LoginPage.java     # Example POM class for Login functionality
│   │   │   │   └── HomePage.java      # Example POM class for Home Page functionality
│   │   │   │
│   │   │   ├── utils/                 # Utility classes and helpers
│   │   │   │   ├── ConfigReader.java  # Reads from config.properties
│   │   │   │   ├── ExtentManager.java # ExtentReports setup
│   │   │   │   ├── TestListener.java  # TestNG listeners for logging and reports
│   │   │   │   └── WebDriverUtils.java # Additional WebDriver helper functions
│   │   │
│   └── resources/
│       ├── extent-config.xml          # Config file for ExtentReports customization
│       └── config.properties          # Configuration file for test data/environment
│
├── src/test/
│   ├── java/
│   │   ├── runner/
│   │   │   └── TestRunner.java        # Cucumber TestNG runner
│   │   ├── stepDefinitions/           # Step definitions for Cucumber
│   │   │   ├── LoginSteps.java        # Example step definitions for Login feature
│   │   ├── tests/                     # TestNG test classes
│   │   │   └── LoginTest.java         # Example TestNG test class for Login functionality
│   │
│   └── resources/                     # This is where test-related resources are kept
│       ├── features/                  # Cucumber feature files (organized inside resources)
│       │   └── Login.feature          # Example feature file for login scenarios
│
├── reports/                           # Extent reports and logs generated from tests
│   └── extent-reports/                # Folder to store the Extent report files


### Execution Flow:
>1.	When you run the tests (via Maven, IntelliJ, or a CI/CD pipeline), TestNG or Cucumber will pick up the classes and run the tests based on the configuration in testng.xml.
>2.	WebDriver is initialized based on the browser type (via DriverFactory).
>3.	Page Objects (e.g., LoginPage) are used to interact with the application, performing actions like clicking buttons, entering text, etc.
>4.	Test Listener captures test results, logs them, and generates Extent Reports.
>5.	The test execution results, along with screenshots (if configured), will be logged in the reports folder under extent-reports/.

## Dependency or import trouble shoot
The error message Cannot resolve symbol 'github' typically occurs when the Maven dependency for WebDriverManager is not correctly downloaded or recognized by your IDE (IntelliJ in this case). There could be a few reasons for this issue:

### Troubleshooting Steps
Check Dependency Synchronization in IntelliJ, Make sure your pom.xml file is properly synchronized with your project. You can do this by:
> 1) Right-clicking on the pom.xml file and selecting "Maven" > "Reimport".
     Or from the Maven toolbar, click the "Reload All Maven Projects" button.
     Force Maven Reimport

> 2) Go to the Maven tool window in IntelliJ (on the right side), expand your project, and click on "Reimport" or "Refresh". This will force IntelliJ to re-download dependencies.

