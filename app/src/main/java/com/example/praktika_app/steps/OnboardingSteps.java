package com.example.praktika_app.steps;

import com.example.praktika_app.pages.page_objects.OnboardingPage;
import org.testng.Assert;

public class OnboardingSteps {
    private OnboardingPage onboardingPage;

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

    public void selectGender(String gender) {
        onboardingPage.waitUntilWelcomeSelectorIsPresented();
        onboardingPage.clickOnButton(gender);
    }

    public void specifyAge(String age) {
        onboardingPage. waitUntilElementIsPresented("How old are you?");
        onboardingPage.clickOnButton(age);
    }

    public void fillName(String name) {
        onboardingPage.waitUntilElementIsPresented("What is your name?");
        onboardingPage.fillInName(name);
        onboardingPage.clickOnButtonContinue();
    }
//TODO remove hardcoded text
    public void selectLanguage(String language) {
        onboardingPage.waitUntilElementIsPresented("What is your");
        onboardingPage.clickOnButton(language);
        onboardingPage.waitUntilSwitchLanguagePopupIsPresented();
        onboardingPage.clickOnSwitchLanguageButton("Switch to Italian");
        onboardingPage.waitUntilElementIsPresented("Ciao!");
    }

    public String getSelectLanguageTitleText() {
        return onboardingPage.getSelectLanguageTitleText("Continua");
    }

    public void verifyLanguageChange(String expectedTitle) {
        String actualTitle = this.getSelectLanguageTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change as expected.");
    }
}
