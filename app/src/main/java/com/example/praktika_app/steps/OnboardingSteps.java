package com.example.praktika_app.steps;

import com.example.praktika_app.pages.page_objects.OnboardingPage;
import org.testng.Assert;
/**
 * Represents the steps to interact with the onboarding page in the Praktika AI application.
 * Provides methods to perform actions and verifications during the onboarding process.
 */
public class OnboardingSteps {
    private OnboardingPage onboardingPage;

    /**
     * Constructor to initialize the OnboardingSteps with an OnboardingPage POM.
     *
     * @param onboardingPage The OnboardingPage instance to interact with.
     */
    public OnboardingSteps(OnboardingPage onboardingPage) {
        this.onboardingPage = onboardingPage;
    }

    public void clickGetStarted() {
        onboardingPage.clickGetStarted("Get Started");
    }

    public void clickAllowNotifications() {
        onboardingPage.waitUntilNotificationPopupIsVisible();
        onboardingPage.clickOnAllowNotificationButton();
    }

    public void specifyGender(String gender) {
        onboardingPage.clickOnButton(gender);
    }

    public void specifyAge(String age) {
        onboardingPage.clickOnButton(age);
    }

    public void specifyLanguage(String language) {
        onboardingPage.clickOnButton(language);
        onboardingPage.waitUntilSwitchLanguagePopupIsPresented();
    }

    public void fillInName(String name) {
        onboardingPage.fillInName(name);
        onboardingPage.clickOnButtonContinue();
    }

    public void clickOnSwitchLanguage(String language) {
        onboardingPage.clickOnSwitchLanguageButton(language);
    }

    public String getSelectLanguageTitleText(String language) {
        return onboardingPage.getSelectLanguageTitleText(language);
    }

    //TODO: This assertion should be moved to dedicated Assertions class
    public void verifyButtonLanguageChange(String expectedTitle) {
        String actualTitle = this.getSelectLanguageTitleText(expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change to the expected language.");
    }
}
