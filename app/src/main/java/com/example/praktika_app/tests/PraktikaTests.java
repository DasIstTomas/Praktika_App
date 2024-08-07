package com.example.praktika_app.tests;

import com.example.praktika_app.tests.tests_core.BaseTest;
import org.testng.annotations.Test;

/**
 * Class for testing the onboarding process and language change functionality in the Praktika AI app.
 * Currently has only one test case within 150-seconds timeout
 */
public class PraktikaTests extends BaseTest {

    @Test(description = "Test onboarding process and change language to Italian", timeOut = 150000)

    public void testOnboardingAndChangeLanguageToItalian() {
        //Given Section

        //When Section
        onboardingSteps.clickGetStarted();
        onboardingSteps.clickAllowNotifications();
        onboardingSteps.specifyGender("Male");
        onboardingSteps.specifyAge("25-34");
        onboardingSteps.fillInName("Arnold Schwarzenegger");
        onboardingSteps.specifyLanguage("Italian");
        onboardingSteps.clickOnSwitchLanguage("Switch to Italian");

        //Then Section
        onboardingSteps.verifyButtonLanguageChange("Continua");
    }
}
