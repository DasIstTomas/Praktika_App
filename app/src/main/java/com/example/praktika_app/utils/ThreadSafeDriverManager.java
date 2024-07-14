package com.example.praktika_app.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeDriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private ThreadSafeDriverManager() {
        // private constructor to prevent instantiation
    }

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            synchronized (ThreadSafeDriverManager.class) {
                if (driver.get() == null) {
                    DesiredCapabilities caps = getDesiredCapabilities();
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

    private static DesiredCapabilities getDesiredCapabilities() {
        Map<String, Object> capsMap = new HashMap<>();
        capsMap.put("platformName", Configuration.PLATFORM_NAME);
        capsMap.put("appium:deviceName", Configuration.DEVICE_NAME);
        capsMap.put("appium:appPackage", Configuration.APP_PACKAGE);
        capsMap.put("appium:appActivity", Configuration.APP_ACTIVITY);
        capsMap.put("appium:automationName", Configuration.AUTOMATION_NAME);
        capsMap.put("appium:noReset", Configuration.NO_RESET_T);

        DesiredCapabilities caps = new DesiredCapabilities(capsMap);
        return caps;
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
