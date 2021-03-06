package AppiumPractice.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import okio.Timeout;
import pageObjectPackage.FormPage;
import pageObjectPackage.HomePage;

public class apiDemosTest extends base{
	
		@BeforeTest
	public void killALLProcess() throws IOException, InterruptedException
	{
		System.out.println("Killing all processes for API DEmos!!!");
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(2000);
		
	}
	
	
	@Test
	public void apiDemos() throws IOException, InterruptedException
	{
		
		// TODO Auto-generated method stub
		startServer();
		
		System.out.println("Setting API Demos capabilities...");
		AndroidDriver<AndroidElement> drivers = capabilities("Emulator","ApiDemos_debugApp");
		
		//Creating an object to link Homepage class 
		HomePage obj = new HomePage(drivers);
		
		
		//This is the way to call variables from HomePage
		//obj.preferences.click();
		
		//drivers.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
		drivers.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.CheckBox[@index='0']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		drivers.findElement(By.id("android:id/edit")).click();
		drivers.findElement(By.id("android:id/edit")).sendKeys("Home");
		drivers.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
	}
	
	@AfterTest
	public void stopServer()
	{
		stopServer();
		System.out.println("Server Stopped.....");
	}

}
