package com.example.praktika_app.tests;

import com.example.praktika_app.pages.OnboardingPage;
import com.example.praktika_app.pages.LanguageSelectionPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PraktikaTest {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private OnboardingPage onboardingPage;
    private LanguageSelectionPage languageSelectionPage;

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

    @Test
    public void testOnboardingAndChangeLanguageToItalian() {
        onboardingPage.clickGetStarted();

        onboardingPage.wainUntilNotificationPopupIsVisible();
        onboardingPage.clickOnAllowNotificationButton();

        onboardingPage.wainUntilWelcomeSelectorIsPresented();
        onboardingPage.clickOnButton("Male");

        onboardingPage.wainUntilSpecifyAgeSelectorIsPresented();
        onboardingPage.clickOnButton("25-34");

        onboardingPage.wainUntilSelectNameSelectorIsPresented();
        //TDB: Name cannot be filled
        onboardingPage.fillInName("Arnold Schwarzenegger");
        onboardingPage.clickOnButtonContinue();

        onboardingPage.wainUntilSelectLanguageSelectorIsPresented("What is your");

        onboardingPage.clickOnButton("Italian");
        onboardingPage.waitUntilSwitchLanguagePopupIsPresented();

        onboardingPage.clickOnSwitchLanguageButton();
        onboardingPage.wainUntilSelectLanguageSelectorIsPresented("Ciao!");

        String actualTitle = onboardingPage.getSelectLanguageTitleText();
        String expectedTitle = "Continua";
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change to Italian.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
