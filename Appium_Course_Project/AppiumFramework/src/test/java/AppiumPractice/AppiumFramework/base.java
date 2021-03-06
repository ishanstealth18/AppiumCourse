package AppiumPractice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class base {
	
	public static AndroidDriver<AndroidElement> driver;
	
	
	//To start appium server automatically
	public static AppiumDriverLocalService service;
	public static final int PORT = 4723;
	//Method to start appium server automatically
	//https://github.com/appium/java-client/blob/master/src/test/java/io/appium/java_client/android/BaseAndroidTest.java
	public void startServer()
	{
		
		
		System.out.println("Inside Start Server Method..");
		System.out.println("Starting the Appium server.....");
		service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(PORT)
                .build();
        service.start();
        System.out.println("Appium server started!!");
		
		
	}
	
	public void stopServer()
	{
		if(service != null)
		{
			service.stop();
			System.out.println("Server stopped!!");
		}
		else
		{
			System.out.println("Appium server not running!!!");
		}
		
	}
	
	//Method to start Emulator on run time
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\Start-Emulator.bat");
		Thread.sleep(45000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String deviceType, String appName) throws IOException, InterruptedException
	{
		
		//Printing current path for pro
		System.out.println(System.getProperty("user.dir"));
		//Set path for global config properties file
		FileInputStream globalConfigFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\AppiumPractice\\AppiumFramework\\globalConfig.properties");
		//Create global properties object and map it with config.properties file 
		Properties p = new Properties();
		p.load(globalConfigFile);
	
		//Declare path for APK
				File appDir = new File("src");
				File f = new File(appDir, (String)p.get(appName));
				
				//Set all the capabilities required for doing automation 
				DesiredCapabilities cap = new DesiredCapabilities();
				
				if(deviceType.equals("Emulator"))
				{
					cap.setCapability(MobileCapabilityType.DEVICE_NAME, p.get(deviceType));
					startEmulator();
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

				driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
				
		return driver;
		
	}
	
	public void getScreenshot(String testFileName) throws IOException
	{
		System.out.println("Inside getScreenShot method...");
		System.out.println("Test File Name for screen shot : " +testFileName);
		System.out.println("Path for screen shots : " +System.getProperty("user.dir")+"\\test-output\\Screenshots\\" +testFileName +".png");
		File screenShotFile = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile,new File(System.getProperty("user.dir")+"\\test-output\\Screenshots\\" +testFileName +".png"));
		
	}
}
