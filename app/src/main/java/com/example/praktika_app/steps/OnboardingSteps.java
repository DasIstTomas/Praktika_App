package com.example.praktika_app.steps;

import com.example.praktika_app.pages.page_objects.OnboardingPage;
import org.testng.Assert;

public class OnboardingSteps {
    private OnboardingPage onboardingPage;

    public OnboardingSteps(OnboardingPage onboardingPage) {
        this.onboardingPage = onboardingPage;
    }

    public void clickGetStarted() {
        onboardingPage.clickGetStarted();
    }

    public void clickAllowNotifications() {
        onboardingPage.waitUntilNotificationPopupIsVisible();
        onboardingPage.clickOnAllowNotificationButton();
    }

    public void selectGender(String gender) {
        onboardingPage.waitUntilWelcomeSelectorIsPresented();
        onboardingPage.clickOnButton(gender);
    }

    public void specifyAge(String age) {
        onboardingPage.waitUntilSpecifyAgeSelectorIsPresented();
        onboardingPage.clickOnButton(age);
    }

    public void fillName(String name) {
        onboardingPage.waitUntilSelectNameSelectorIsPresented();
        onboardingPage.fillInName(name);
        onboardingPage.clickOnButtonContinue();
    }

    public void selectLanguage(String language) {
        onboardingPage.waitUntilSelectLanguageSelectorIsPresented("What is your");
        onboardingPage.clickOnButton(language);
        onboardingPage.waitUntilSwitchLanguagePopupIsPresented();
        onboardingPage.clickOnSwitchLanguageButton();
        onboardingPage.waitUntilSelectLanguageSelectorIsPresented("Ciao!");
    }

    public String getSelectLanguageTitleText() {
        return onboardingPage.getSelectLanguageTitleText();
    }

    public void verifyLanguageChange(String expectedTitle) {
        String actualTitle = this.getSelectLanguageTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change as expected.");
    }
}
