package com.example.praktika_app.pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all page objects in the Praktika AI application.
 * Provides common setup and initialization for page objects.
 */
public class BasePage {
    protected AppiumDriver driver;

    /**
     * Constructor to initialize the BasePage with an AppiumDriver.
     *
     * @param driver The AppiumDriver instance to interact with.
     */
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}