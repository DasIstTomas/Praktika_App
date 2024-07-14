package com.example.praktika_app.tests.tests_core;

import java.net.MalformedURLException;
import java.net.URL;

public class Configuration {
    //Desired Capabilities Section
    public static final String PLATFORM_NAME = "Android";
    public static final String DEVICE_NAME = "emulator-5554";
    public static final String APP_PACKAGE = "ai.praktika.android";
    public static final String APP_ACTIVITY = ".MainActivity";
    public static final String AUTOMATION_NAME = "UiAutomator2";
    public static final boolean NO_RESET_T = true;

    //The rest configuration
    public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";
    public static final long TIMEOUT_IN_SECONDS = 10;

    public static URL getAppiumServerUrl() throws MalformedURLException {
        return new URL(APPIUM_SERVER_URL);
    }
}