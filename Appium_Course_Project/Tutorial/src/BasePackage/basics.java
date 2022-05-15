package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import okio.Timeout;
import pageObjectPackage.HomePage;

public class basics extends base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> drivers = capabilities("real");
		
		//Creating an object to link Homepage class 
		HomePage obj = new HomePage(drivers);
		
		//This is the way to call variables from HomePage
		//obj.preferences.click();
		
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
		drivers.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.CheckBox[@index='0']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		drivers.findElement(By.id("android:id/edit")).click();
		drivers.findElement(By.id("android:id/edit")).sendKeys("Home");
		drivers.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
	}

}
