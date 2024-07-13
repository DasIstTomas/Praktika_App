plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.praktika_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.praktika_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.testng)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Add Appium, TestNG, Selenium, Apache Commons Lang, and SLF4J dependencies
    implementation("io.appium:java-client:8.0.0")
    testImplementation("org.testng:testng:7.4.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.1.2")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.slf4j:slf4j-simple:1.7.30") // Simple logger implementation
}
