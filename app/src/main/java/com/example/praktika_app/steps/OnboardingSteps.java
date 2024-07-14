package com.example.praktika_app.steps;

import com.example.praktika_app.pages.page_objects.OnboardingActivity;
import org.testng.Assert;

public class OnboardingSteps {
    private OnboardingActivity onboardingActivity;

    public OnboardingSteps(OnboardingActivity onboardingActivity) {
        this.onboardingActivity = onboardingActivity;
    }

    public void clickGetStarted() {
        onboardingActivity.clickGetStarted();
    }

    public void allowNotifications() {
        onboardingActivity.waitUntilNotificationPopupIsVisible();
        onboardingActivity.clickOnAllowNotificationButton();
    }

    public void selectGender(String gender) {
        onboardingActivity.waitUntilWelcomeSelectorIsPresented();
        onboardingActivity.clickOnButton(gender);
    }

    public void specifyAge(String age) {
        onboardingActivity.waitUntilSpecifyAgeSelectorIsPresented();
        onboardingActivity.clickOnButton(age);
    }

    public void fillName(String name) {
        onboardingActivity.waitUntilSelectNameSelectorIsPresented();
        onboardingActivity.fillInName(name);
        onboardingActivity.clickOnButtonContinue();
    }

    public void selectLanguage(String language) {
        onboardingActivity.waitUntilSelectLanguageSelectorIsPresented("What is your");
        onboardingActivity.clickOnButton(language);
        onboardingActivity.waitUntilSwitchLanguagePopupIsPresented();
        onboardingActivity.clickOnSwitchLanguageButton();
        onboardingActivity.waitUntilSelectLanguageSelectorIsPresented("Ciao!");
    }

    public String getSelectLanguageTitleText() {
        return onboardingActivity.getSelectLanguageTitleText();
    }

    public void verifyLanguageChange(String expectedTitle) {
        String actualTitle = this.getSelectLanguageTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change as expected.");
    }
}
