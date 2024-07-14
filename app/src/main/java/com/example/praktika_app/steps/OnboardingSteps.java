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

    public void specifyGender(String gender) {
//        onboardingPage.waitUntilElementIsPresented("Welcome to Praktika!");
        onboardingPage.clickOnButton(gender);
    }

    public void specifyAge(String age) {
//        onboardingPage.waitUntilElementIsPresented("How old are you?");
        onboardingPage.clickOnButton(age);
    }

    public void fillInName(String name) {
//        onboardingPage.waitUntilElementIsPresented("What is your name?");
        onboardingPage.fillInName(name);
        onboardingPage.clickOnButtonContinue();
    }
//TODO remove hardcoded text
    public void specifyLanguage(String language) {
        onboardingPage.clickOnButton(language);
        onboardingPage.waitUntilSwitchLanguagePopupIsPresented();
    }

    public void clickOnSwitchLanguage(String language) {
        onboardingPage.clickOnSwitchLanguageButton(language);
    }


    public String getSelectLanguageTitleText(String language) {
        return onboardingPage.getSelectLanguageTitleText(language);
    }

    public void verifyButtonLanguageChange(String expectedTitle) {
        String actualTitle = this.getSelectLanguageTitleText(expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Language did not change to the expected language.");
    }
}
