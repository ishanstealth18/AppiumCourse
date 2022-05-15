package BasePackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	
	
	public static AndroidDriver<AndroidElement> capabilities(String deviceType) throws MalformedURLException
	{
		//Declare path for APK
				File appDir = new File("src/BasePackage");
				File f = new File(appDir, "General-Store.apk");
				
				//Set all the capabilities required for doing automation 
				DesiredCapabilities cap = new DesiredCapabilities();
				
				if(deviceType.equals("emulator"))
				{
					cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
				}
				else if(deviceType.equals("real"))
				{
					cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
				}
				else
				{
					System.out.println("please enter device type!!");
				}
				
				cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

				//Connect Android driver with capabilities object so it can invoke automation
				AndroidDriver<AndroidElement> aDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
				
		return aDriver;
		
	}
}
