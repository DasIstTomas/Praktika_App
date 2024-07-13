package com.example.praktika_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingPage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@content-desc='Get Started']")
    private WebElement getStartedButton;

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickGetStarted() {
        getStartedButton.click();
    }
}
