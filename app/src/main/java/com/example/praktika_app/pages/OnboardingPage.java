package com.example.praktika_app.pages;

import com.example.praktika_app.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.AppiumDriver;

public class OnboardingPage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@content-desc='Get Started']")
    private WebElement getStartedButton;

    @FindBy(xpath = "//android.view.View[@content-desc='👋 Welcome to Praktika!\nChoose your gender']")
    private WebElement welcomeSelector;

    @FindBy(xpath = "//android.view.View[contains(@content-desc, 'How old are you?')]")
    private WebElement ageSelector;

    @FindBy(xpath = "//android.view.View[contains(@content-desc, 'What is your name?')]")
    private WebElement nameSelector;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ui_textEdit_Name\"]")
    private WebElement nameInputField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Continue\"]")
    private WebElement continueButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]")
    private WebElement notificationPopUp;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement allowNotificationButton;

    @FindBy(xpath = "//*[@resource-id='ui_bsButton_SwitchTo']")
    private WebElement switchLanguagePopup;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Switch to Italian\"]")
    private WebElement switchLanguageButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Continua\"]")
    private WebElement italianContinueButton;

    // Template Locators
    private String buttonXPathTemplate = "//android.view.View[contains(@content-desc, '%s')]";
    private String selectLanguageTitleXPathTemplate = "//android.view.View[contains(@content-desc, '%s')]";

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    // Wait Methods
    public void waitUntilWelcomeSelectorIsPresented() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(welcomeSelector));
    }

    public void waitUntilNotificationPopupIsVisible() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(notificationPopUp));
    }

    public void waitUntilSpecifyAgeSelectorIsPresented() {
        WaitUtils.getWait(driver).until(ExpectedConditions.elementToBeClickable(ageSelector));
    }

    public void waitUntilSelectNameSelectorIsPresented() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(nameSelector));
    }

    public void waitUntilSelectLanguageSelectorIsPresented(String text) {
        String buttonXPath = String.format(selectLanguageTitleXPathTemplate, text);
        WaitUtils.getWait(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXPath)));
    }

    public void waitUntilSwitchLanguagePopupIsPresented() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(switchLanguagePopup));
    }

    // Action Methods
    public void clickGetStarted() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(getStartedButton));
        getStartedButton.click();
    }

    public void clickOnAllowNotificationButton() {
        allowNotificationButton.click();
    }

    public void clickOnSwitchLanguageButton() {
        switchLanguageButton.click();
    }

    public void clickOnButton(String buttonText) {
        String buttonXPath = String.format(buttonXPathTemplate, buttonText);
        WebElement button = WaitUtils.getWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
        button.click();
    }

    public void fillInName(String name) {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.click();
        nameInputField.sendKeys(name);
    }

    public void clickOnButtonContinue() {
        continueButton.click();
    }

    public String getSelectLanguageTitleText() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(italianContinueButton));
        return italianContinueButton.getAttribute("content-desc");
    }
}
