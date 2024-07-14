package com.example.praktika_app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


//TBD: Restructure the sections for waiters, clicks and other methods
public class OnboardingPage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@content-desc='Get Started']")
    private WebElement getStartedButton;

    //TBD: Don't use text in locator. Antipattern
    @FindBy(xpath = "//android.view.View[@content-desc='👋 Welcome to Praktika!\nChoose your gender']")
    private WebElement welcomeSelector;

    //TBD: Don't use text in locator. Antipattern. Also, look for an xpath duplicate
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


//    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
//    private WebElement selectLanguageItalianTitle;

    //Template Locators section
    private String buttonXPathTemplate = "//android.view.View[contains(@content-desc, '%s')]";
    private String selectLanguageTitleXPathTemplate = "//android.view.View[contains(@content-desc, '%s')]";

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Click on 'Get started'")
    public void clickGetStarted() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getStartedButton));
        getStartedButton.click();
    }

    public String getSelectLanguageTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(italianContinueButton));
//        if (italianContinueButton.isDisplayed()) {
//            System.out.println("Button is displayed");
//        } else {
//            System.out.println("Button is NOT displayed");
//        }
        String contentDesc = italianContinueButton.getAttribute("content-desc");
//        System.out.println("Content-desc: " + contentDesc);
        return contentDesc;
    }

    public void wainUntilWelcomeSelectorIsPresented() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(welcomeSelector));
    }

    public void wainUntilNotificationPopupIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(notificationPopUp));
    }

    public void clickOnAllowNotificationButton() {
        allowNotificationButton.click();
    }


    public void clickOnSwitchLanguageButton() {
        switchLanguageButton.click();
    }
//    TBD
    public void clickOnButton(String buttonText) {
        String buttonXPath = String.format(buttonXPathTemplate, buttonText);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
        button.click();
    }

    public void wainUntilSpecifyAgeSelectorIsPresented() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ageSelector));
    }

    public void wainUntilSelectNameSelectorIsPresented() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(nameSelector));
    }

    public void wainUntilSelectLanguageSelectorIsPresented(String text) {
        String buttonXPath = String.format(selectLanguageTitleXPathTemplate, text);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXPath)));
    }

    public void waitUntilSwitchLanguagePopupIsPresented() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(switchLanguagePopup));
    }

    public void fillInName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.click();
        nameInputField.sendKeys(name);
    }

    public void clickOnButtonContinue() {
        continueButton.click();
    }

}
