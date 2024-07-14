package com.example.praktika_app.tests.tests_core;

import com.example.praktika_app.pages.OnboardingPage;
import com.example.praktika_app.pages.LanguageSelectionPage;
import com.example.praktika_app.steps.OnboardingSteps;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class BaseTest {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected OnboardingPage onboardingPage;
    protected LanguageSelectionPage languageSelectionPage;
    protected OnboardingSteps onboardingSteps;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "ai.praktika.android");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(appiumServerUrl, caps);
        wait = new WebDriverWait(driver, 10);

        onboardingPage = new OnboardingPage(driver);
        languageSelectionPage = new LanguageSelectionPage(driver);
        onboardingSteps = new OnboardingSteps(onboardingPage);
    }

    @BeforeMethod
    public void clearAppData() throws IOException, InterruptedException {
        // Clear app data
        ProcessBuilder clearData = new ProcessBuilder("adb", "shell", "pm", "clear", "ai.praktika.android");
        Process clearProcess = clearData.start();
        clearProcess.waitFor();

        // Launch the app
        ProcessBuilder launchApp = new ProcessBuilder("adb", "shell", "am", "start", "-n", "ai.praktika.android/.MainActivity");
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
