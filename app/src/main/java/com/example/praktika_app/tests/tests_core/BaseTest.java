package com.example.praktika_app.tests.tests_core;

import com.example.praktika_app.pages.page_objects.OnboardingPage;
import com.example.praktika_app.steps.OnboardingSteps;
import com.example.praktika_app.utils.Configuration;
import com.example.praktika_app.utils.ThreadSafeDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
/**
 * Base class for all tests in the Praktika AI application.
 * Provides common setup and teardown methods for test classes.
 */
public class BaseTest {
    protected AppiumDriver driver;
    protected OnboardingPage onboardingPage;
    protected OnboardingSteps onboardingSteps;

    /**
     * Sets up the driver, and page objects before the test class is run.
     */
    @BeforeClass
    public void setUp() {
        driver = ThreadSafeDriverManager.getDriver();

        onboardingPage = new OnboardingPage(driver);
        onboardingSteps = new OnboardingSteps(onboardingPage);
    }

    /**
     * Clears app data and relaunches the app before each test method.
     *
     * @throws IOException if an I/O error occurs during the process.
     * @throws InterruptedException if the current thread is interrupted while waiting.
     */
    @BeforeMethod
    public void clearAppData() throws IOException, InterruptedException {
        // Clear app data
        ProcessBuilder clearData = new ProcessBuilder("adb", "shell", "pm", "clear", Configuration.APP_PACKAGE);
        Process clearProcess = clearData.start();
        clearProcess.waitFor();

        // Launch the app
        ProcessBuilder launchApp = new ProcessBuilder("adb", "shell", "am", "start", "-n", Configuration.APP_PACKAGE + "/" + Configuration.APP_ACTIVITY);
        Process launchProcess = launchApp.start();
        launchProcess.waitFor();
    }

    /**
     * Quits the driver after the test class is run.
     */
    @AfterClass
    public void tearDown() {
        ThreadSafeDriverManager.quitDriver();
    }
}
