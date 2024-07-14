package com.example.praktika_app.tests;

import com.example.praktika_app.tests.tests_core.BaseTest;
import org.testng.annotations.Test;

public class PraktikaTests extends BaseTest {

    @Test(description = "Test onboarding process and change language to Italian")
    public void testOnboardingAndChangeLanguageToItalian() {
        //Given Section
        //When Section
        onboardingSteps.clickGetStarted();
        onboardingSteps.clickAllowNotifications();
        onboardingSteps.specifyGender("Male");
        onboardingSteps.specifyAge("25-34");
        onboardingSteps.fillInName("Arnold Schwarzenegger");
        onboardingSteps.specifyLanguage("Italian");

        //Then Section
        onboardingSteps.verifyButtonLanguageChange("Continua");
    }
}
