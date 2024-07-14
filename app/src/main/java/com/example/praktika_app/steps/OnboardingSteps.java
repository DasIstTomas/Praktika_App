package com.example.praktika_app.steps;

import com.example.praktika_app.pages.OnboardingPage;

import org.testng.Assert;

public class OnboardingSteps {
    private OnboardingPage onboardingPage;

    public OnboardingSteps(OnboardingPage onboardingPage) {
        this.onboardingPage = onboardingPage;
    }

    public void clickGetStarted() {
        onboardingPage.clickGetStarted();
    }

    public void allowNotifications() {
        onboardingPage.wainUntilNotificationPopupIsVisible();
        onboardingPage.clickOnAllowNotificationButton();
    }

    public void selectGender(String gender) {
        onboardingPage.wainUntilWelcomeSelectorIsPresented();
        onboardingPage.clickOnButton(gender);
    }

    public void specifyAge(String age) {
        onboardingPage.wainUntilSpecifyAgeSelectorIsPresented();
        onboardingPage.clickOnButton(age);
    }

    public void fillName(String name) {
        onboardingPage.wainUntilSelectNameSelectorIsPresented();
        onboardingPage.fillInName(name);
        onboardingPage.clickOnButtonContinue();
    }

    public void selectLanguage(String language) {
        onboardingPage.wainUntilSelectLanguageSelectorIsPresented("What is your");
        onboardingPage.clickOnButton(language);
        onboardingPage.waitUntilSwitchLanguagePopupIsPresented();
        onboardingPage.clickOnSwitchLanguageButton();
        onboardingPage.wainUntilSelectLanguageSelectorIsPresented("Ciao!");
    }

    public String getSelectLanguageTitleText() {
        return onboardingPage.getSelectLanguageTitleText();
    }

    public void verifyLanguageExpectedLanguage(String expectedTitle) {
        String actualTitle = this.getSelectLanguageTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change to Italian.");

    }
}
