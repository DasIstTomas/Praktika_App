package com.example.praktika_app.pages.page_objects;

import com.example.praktika_app.pages.BasePage;
import com.example.praktika_app.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.AppiumDriver;

public class OnboardingPage extends BasePage {



    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ui_textEdit_Name\"]")
    private WebElement nameInputField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]")
    private WebElement notificationPopUp;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement allowNotificationButton;

    @FindBy(xpath = "//*[@resource-id='ui_bsButton_SwitchTo']")
    private WebElement switchLanguagePopup;

    @FindBy(xpath = "//android.view.View[@content-desc='👋 Welcome to Praktika!\nChoose your gender']")
    private WebElement welcomeSelector;

    // Template Locators Section. These locators are points to ask developers to add robust attributes to XML DOM tree
    private String commonTextContainerXpath = "//android.view.View[contains(@content-desc, '%s')]";
    private String buttonXPathTemplate = "//android.widget.Button[@content-desc='%s']";

    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }
    //Handling elements by common locators method
    private WebElement getButtonByCommonXpathTemplate(String buttonText) {
        String buttonXPath = String.format(buttonXPathTemplate, buttonText);
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonXPath)));
        return driver.findElement(By.xpath(buttonXPath));
    }

    // Wait Methods
    public void waitUntilWelcomeSelectorIsPresented() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(welcomeSelector));
    }

    public void waitUntilNotificationPopupIsVisible() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(notificationPopUp));
    }

    public void waitUntilElementIsPresented(String text) {
        String buttonXPath = String.format(commonTextContainerXpath, text);
        WaitUtils.getWait(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXPath)));
    }

    public void waitUntilSwitchLanguagePopupIsPresented() {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(switchLanguagePopup));
    }

    // Action Methods
    public void clickGetStarted(String buttonText) {
        WebElement element = getButtonByCommonXpathTemplate(buttonText);
        element.click();
    }

    public void clickOnAllowNotificationButton() {
        allowNotificationButton.click();
    }

    public void clickOnSwitchLanguageButton(String textToClick) {
        getButtonByCommonXpathTemplate(textToClick).click();
    }

    public void clickOnButton(String buttonText) {
        String buttonXPath = String.format(commonTextContainerXpath, buttonText);
        WebElement button = WaitUtils.getWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));
        button.click();
    }

    public void fillInName(String name) {
        WaitUtils.getWait(driver).until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.click();
        nameInputField.sendKeys(name);
    }

    public void clickOnButtonContinue() {
        getButtonByCommonXpathTemplate("Continue").click();
    }

    public String getSelectLanguageTitleText(String textToClick) {
        WebElement element = getButtonByCommonXpathTemplate(textToClick);
        return element.getAttribute("content-desc");
    }
}
