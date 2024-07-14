package com.example.praktika_app.pages.page_objects;

import com.example.praktika_app.pages.BasePage;
import com.example.praktika_app.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
/**
 * Represents the onboarding page of the Praktika application.
 * Provides methods to interact with various elements on the onboarding page.
 */
public class OnboardingPage extends BasePage {

    //Web Element Declarations
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ui_textEdit_Name\"]")
    private WebElement nameInputField;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]")
    private WebElement notificationPopUp;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement allowNotificationButton;

    @FindBy(xpath = "//*[@resource-id='ui_bsButton_SwitchTo']")
    private WebElement switchLanguagePopup;

    // Template Locators Section. These locators are points to ask developers to add robust attributes to XML DOM tree
    private String commonTextContainerXpath = "//android.view.View[contains(@content-desc, '%s')]";
    private String buttonXPathTemplate = "//android.widget.Button[@content-desc='%s']";

    /**
     * Constructor to initialize the OnboardingPage with an Appium driver.
     *
     * @param driver The Appium driver.
     */
    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }
    //Handling elements by common locators method
    private WebElement getButtonByCommonXpathTemplate(String buttonText) {
        String buttonXPath = String.format(buttonXPathTemplate, buttonText);
        return WaitUtils.waitForElementLocatedBy(driver, By.xpath(buttonXPath));
    }

    // Wait Methods Section
    public void waitUntilNotificationPopupIsVisible() {
        WaitUtils.waitForElementLocatedBy(driver, notificationPopUp);
    }

    public void waitUntilSwitchLanguagePopupIsPresented() {
        WaitUtils.waitForElementLocatedBy(driver, switchLanguagePopup);
    }

    // Action Methods
    public void clickGetStarted(String buttonText) {
        WebElement element = getButtonByCommonXpathTemplate(buttonText);
        element.click();
    }

    public void clickOnAllowNotificationButton() {
        WaitUtils.waitForElementLocatedBy(driver, allowNotificationButton).click();
    }

    public void clickOnSwitchLanguageButton(String textToClick) {
        getButtonByCommonXpathTemplate(textToClick).click();
    }

    public void clickOnButton(String buttonText) {
        WaitUtils.waitForElementLocatedBy(driver, By.xpath(String.format(commonTextContainerXpath, buttonText))).click();
    }

    public void fillInName(String name) {
        WebElement element = WaitUtils.waitForElementLocatedBy(driver, nameInputField);
        element.click();
        element.sendKeys(name);
    }

    public void clickOnButtonContinue() {
        getButtonByCommonXpathTemplate("Continue").click();
    }

    /**
     * Retrieves the content description of a button based on the provided text.
     *
     * @param textToClick The text used to locate the button.
     * @return The content description of the button.
     */
    public String getSelectLanguageTitleText(String textToClick) {
        WebElement element = getButtonByCommonXpathTemplate(textToClick);
        return element.getAttribute("content-desc");
    }
}
