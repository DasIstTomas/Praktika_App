package com.example.praktika_app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for managing explicit waits in Selenium tests.
 */
public class WaitUtils {
    private static final Duration TIMEOUT = Duration.ofSeconds(Configuration.TIMEOUT_IN_SECONDS);

    /**
     * Creates and returns a WebDriverWait instance with the specified timeout.
     *
     * @param driver the WebDriver instance
     * @return the WebDriverWait instance
     */
    public static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, TIMEOUT);
    }

    /**
     * Waits until the specified element is visible on the page.
     *
     * @param driver  the WebDriver instance
     * @param element the WebElement to wait for
     * @return the visible WebElement
     */
    public static WebElement waitForElementLocatedBy(WebDriver driver, WebElement element) {
        getWait(driver).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Waits until an element located by the specified locator is visible on the page.
     *
     * @param driver  the WebDriver instance
     * @param locator the By locator to locate the element
     * @return the visible WebElement
     */
    public static WebElement waitForElementLocatedBy(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
