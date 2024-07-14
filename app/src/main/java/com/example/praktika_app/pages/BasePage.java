package com.example.praktika_app.pages;

import com.example.praktika_app.utils.ThreadSafeDriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}