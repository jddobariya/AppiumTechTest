Capabilities for Appium inspector
{
  "appium:platformName": "Android",
  "appium:platformVersion": "14.0",
  "appium:automationName": "UIAutomator2",
  "appium:deviceName": "emulator-5554",
  "appium:appPackage": "com.wallet.crypto.trustapp",
  "appium:appActivity": "com.wallet.crypto.trustapp.ui.app.AppActivity"
}


==========Installation prerequisities========
Latest Node.Js
Latest Android
Lated JDK
Latest Eclipse
Appium 2.0 installed using NPM( Appium desktop has been deprecated)

Set the Environment variables
System Variable (ANDROID HOME)
C:\Users\jd_do\AppData\Local\Android\Sdk

PATH to be edited to add 
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\cmdline-tools\latest\bin
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin

====== Running the tests==================
Open command prompt and issue the command appium to start the appium server
Open Android studio and add the device Pixel 8 PRo API 34. And Start the device
Open eclipse
Go to src/test/resources/tustwallettechtest/bdd/CreateWallet.feature file and double click
Right click on the Scenario and Run as 1 Cucumber Feature

=======================================================================