## Praktika AI Mobile App: 
## Android Automated tests Demonstration, Preparations and Must-Know Things Before Tests Start

### Demonstration
Kindly, find a link to a loom recorder website for a [demonstration recording](https://www.loom.com/share/f7d82adb437f498db912bd7ca765ab8a)

### Environment Setup on Windows and Starting Tests

Before running the tests, you need to prepare your environment:

1. **Install Java Development Kit (JDK):**
   - Download and install JDK from the [official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Set the `JAVA_HOME` environment variable to the JDK installation path.

2. **Install Android Studio:**
   - Download and install Android Studio from the [official website](https://developer.android.com/studio).
   - Set up the Android SDK and ensure that the `ANDROID_HOME` environment variable is set to the SDK path.

3. **Install Appium:**
   - Install Appium Server from the [official website](https://appium.io/).
   - Start the Appium Server. (Please notice that ip and port can be different as its defined in the Settings class)

4. **Set Up an Android Emulator:**
   - Open Android Studio and navigate to the AVD Manager.
   - Create a new virtual device with a minimum SDK version of 26.
   - Start the emulator.
   - (point to improve) Manually install :Praktika AI" from Google Store.
     
5. **Run the automated tests using embded Android Studio UI button**
   - Refer to the dir with [developed code](https://github.com/DasIstTomas/Praktika_App/tree/main/app/src/main/java/com/example/praktika_app)
   - Go to tests folder and find PractikaTests.java
   - Click on embded play button to run the automated test
     Note: The most interesing files you will find in the dir above.
   
### Warning

- Ensure that the minimum SDK version for the emulator is set to 26.

## Test Case Description

The test case covers change of language during onboarding. The case has the following steps:

1. Click "Get started."
2. Go through onboarding to the language selection screen.
3. Change the language to Italian.

Note: The test is repeatable regradless of state of the installed app.

### Automated Test Actions

- Click the "Get started" button.
- Allow notifications.
- Specify gender and age.
- Fill in the name.
- Specify and switch the language to Italian.
- Verify the language change by checking the text of the "Continue" button.

## Potential Improvement Points and Exclamation Marks

1. **Add an HTML Report:**
   - Refer to the branch [`allure-integration`](https://github.com/DasIstTomas/Praktika_App/tree/allure-integration) to find unfinished work on integrating Allure for HTML reports.

2. **Add Assertions:**
   - Add assertions for the rest of the elements after switching the language to Italian.
   - Check language before changing it to compare previous and picked locales

3. **Refactor Assertions:**
   - Move assertions to a new file, separating them from the steps layer for better maintainability.

4. **Parameterize Test Execution:**
   - Enable the test to run either on an emulator or a real device through parameterization.

5. **Add `onCurrentPage` Method:**
   - Implement an `onCurrentPage` method to always understand from the code on which layout user should be in order to easily access any mobile element of the currently opened activity.

6. **Use `ThreadSafeDriverManager`:**
   - Though introducing `ThreadSafeDriverManager` may seem extra, it provides maintainability and scalability, allowing for parallel test runs.

7. **Use `MobileElement`:**
   - It's recommended to use `MobileElement` for cross-platform compatibility (iOS and Android).

8. **To reduce avoid tests`:**
   - I ran tests with enablded Fidler to emulate a slower internet speed
   - I would add more waitings, like not only waiting for UI elements but also http exchanges to be completed, etc.
  
<details>
  <summary>Click to expand</summary>
  
  ## Spoiler Content
  
  Here you can add your spoiler content. This can include text, code snippets, images, or any other Markdown content.
  
  ```javascript
  // Example code snippet
  console.log('Hello, world!');

