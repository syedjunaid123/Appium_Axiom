package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {

		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
//			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86_64");			
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(MobileCapabilityType.APP, "/Users/xebia/eclipse-workspace/Axiom/axiom/src/test/resources/apps/com.landmarkgroup.centrepointstores_2020-08-18.apk");
//			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			caps.setCapability("appPackage", "com.landmarkgroup.centrepointstores");
			caps.setCapability("appActivity", "com.landmarkgroupreactapps.MainActivity");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			driver = new AppiumDriver<MobileElement>(url, caps);
//			driver = new AndroidDriver<MobileElement>(url, caps);
			
		}
		catch(Exception exp){
			System.out.println("Cause id: "+exp.getCause());
			System.out.println("Message is: "+exp.getMessage());
			exp.printStackTrace();
		}

	}

	
	@Test
	public void sampleTest() {
		System.out.println("Appium is lunached");
	}

	@AfterTest
	public void teardown() {

	}

}
