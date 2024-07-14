package com.example.praktika_app.tests.tests_core;

import com.example.praktika_app.pages.page_objects.OnboardingActivity;
import com.example.praktika_app.steps.OnboardingSteps;
import com.example.praktika_app.utils.Configuration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected OnboardingActivity onboardingActivity;
    protected OnboardingSteps onboardingSteps;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", Configuration.PLATFORM_NAME);
        caps.setCapability("deviceName", Configuration.DEVICE_NAME);
        caps.setCapability("appPackage", Configuration.APP_PACKAGE);
        caps.setCapability("appActivity", Configuration.APP_ACTIVITY);
        caps.setCapability("automationName", Configuration.AUTOMATION_NAME);
        caps.setCapability("noReset", Configuration.NO_RESET_T);

        driver = new AndroidDriver(Configuration.getAppiumServerUrl(), caps);
        wait = new WebDriverWait(driver, 10);

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
        if (driver != null) {
            driver.quit();
        }
    }
}
