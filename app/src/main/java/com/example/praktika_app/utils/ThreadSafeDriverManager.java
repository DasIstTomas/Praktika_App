package com.example.praktika_app.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class ThreadSafeDriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private ThreadSafeDriverManager() {
        // private constructor to prevent instantiation
    }

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            synchronized (ThreadSafeDriverManager.class) {
                if (driver.get() == null) {
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("platformName", Configuration.PLATFORM_NAME);
                    caps.setCapability("deviceName", Configuration.DEVICE_NAME);
                    caps.setCapability("appPackage", Configuration.APP_PACKAGE);
                    caps.setCapability("appActivity", Configuration.APP_ACTIVITY);
                    caps.setCapability("automationName", Configuration.AUTOMATION_NAME);
                    caps.setCapability("noReset", Configuration.NO_RESET_T);

                    try {
                        driver.set(new AndroidDriver(Configuration.getAppiumServerUrl(), caps));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to initialize Appium Driver", e);
                    }
                }
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
