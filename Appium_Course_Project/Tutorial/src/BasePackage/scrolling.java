package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

public class scrolling extends base{

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> drivers = capabilities("real");
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		Thread.sleep(2000);
		
		//Scroll functions
		drivers.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"WebView3\"))")).click();
		
		
		

	}

}
