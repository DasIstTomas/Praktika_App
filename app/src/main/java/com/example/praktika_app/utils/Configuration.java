package com.example.praktika_app.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Configuration class for setting up the desired capabilities and other configurations for the Appium tests.
 */
public class Configuration {
    // Desired Capabilities Section

    /** Platform name for the mobile device. */
    public static final String PLATFORM_NAME = "Android";

    /** Device name for the mobile device. */
    public static final String DEVICE_NAME = "emulator-5554";

    /** App package name for the application under test. */
    public static final String APP_PACKAGE = "ai.praktika.android";

    /** App activity name for the main activity of the application under test. */
    public static final String APP_ACTIVITY = ".MainActivity";

    /** Automation engine name used by Appium. */
    public static final String AUTOMATION_NAME = "UiAutomator2";

    /** Flag to indicate whether to reset the application state between sessions. */
    public static final boolean NO_RESET_T = true;

    // Rest Configuration Section

    /** URL of the Appium server. */
    public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    /** Timeout duration in seconds for waiting for elements. */
    public static final long TIMEOUT_IN_SECONDS = 30;

    /**
     * Gets the URL of the Appium server.
     *
     * @return the URL of the Appium server.
     * @throws MalformedURLException if the URL is malformed.
     */
    public static URL getAppiumServerUrl() throws MalformedURLException {
        return new URL(APPIUM_SERVER_URL);
    }
}
