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
        onboardingSteps.selectGender("Male");
        onboardingSteps.specifyAge("25-34");
        onboardingSteps.fillName("Arnold Schwarzenegger");
        onboardingSteps.selectLanguage("Italian");

        //Then Section
        onboardingSteps.verifyLanguageChange("Continua");
    }
}
