package trustwallettechtest.bdd;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Driver {

	public static AndroidDriver driver;

	public static void StartDriver()
	{
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformVersion","14.0");
			capabilities.setCapability("platformName","Android");
			capabilities.setCapability("deviceName","TrustWalletPixelPro");
			capabilities.setCapability("udid","emulator-5554");
			capabilities.setCapability("automationName", "UIAutomator2");
			capabilities.setCapability(CapabilityType.TIMEOUTS,60);
			capabilities.setCapability("noReset","true");


			URL url = null;
			try {
				url = new URL("http://127.0.0.1:4723");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new AndroidDriver(url,capabilities);
			boolean IsAppInstalled = driver.isAppInstalled("com.wallet.crypto.trustapp");
			if(IsAppInstalled) {
				driver.removeApp("com.wallet.crypto.trustapp");
			}
			driver.installApp(System.getProperty("user.dir")+"\\src\\test\\resources\\apps\\v8.7.1_release.apk");
			driver.activateApp("com.wallet.crypto.trustapp");
			Thread.sleep(5000);
			
		}
		catch(Exception e) {
			System.out.println(e.getCause());
		}
	}
}
