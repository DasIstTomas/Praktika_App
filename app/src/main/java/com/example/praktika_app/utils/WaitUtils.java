package com.example.praktika_app.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
    private static final Duration TIMEOUT = Duration.ofSeconds(Configuration.TIMEOUT_IN_SECONDS);

    public static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, TIMEOUT);
    }
}
