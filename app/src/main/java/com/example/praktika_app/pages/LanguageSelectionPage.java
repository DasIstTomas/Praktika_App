package com.example.praktika_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageSelectionPage extends BasePage {

    @FindBy(id = "com.example.praktikaai:id/languageDropdown")
    private WebElement languageDropdown;

    @FindBy(xpath = "//android.widget.TextView[@text='Spanish']")
    private WebElement languageOption;

    @FindBy(id = "com.example.praktikaai:id/selectedLanguage")
    private WebElement selectedLanguage;

    public LanguageSelectionPage(AppiumDriver driver) {
        super(driver);
    }

    public void changeLanguageToSpanish() {
        languageDropdown.click();
        languageOption.click();
    }

    public String getSelectedLanguage() {
        return selectedLanguage.getText();
    }
}
