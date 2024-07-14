package com.example.praktika_app.tests.tests_core;

import com.example.praktika_app.pages.page_objects.OnboardingActivity;
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

public class BaseTest {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected OnboardingActivity onboardingActivity;
    protected OnboardingSteps onboardingSteps;

    @BeforeClass
    public void setUp() {
        driver = ThreadSafeDriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Configuration.TIMEOUT_IN_SECONDS));

        onboardingActivity = new OnboardingActivity(driver);
        onboardingSteps = new OnboardingSteps(onboardingActivity);
    }

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

    @AfterClass
    public void tearDown() {
        ThreadSafeDriverManager.quitDriver();
    }
}
