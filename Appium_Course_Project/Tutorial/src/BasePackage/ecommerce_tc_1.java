package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class ecommerce_tc_1 extends base{
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> drivers = capabilities("emulator");
		Thread.sleep(3000);
		//drivers.findElement(By.id("com.androidsample.generalstore:id/nameField")).isDisplayed();
		//drivers.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		//drivers.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ishan");
		//drivers.hideKeyboard();
		
		//Thread.sleep(3000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(3000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		Thread.sleep(3000);
		
		//Scroll functions
		drivers.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\"India\"))")).click();
		Thread.sleep(3000);
		
		drivers.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Thread.sleep(5000);
		
		String nameToastMsg = drivers.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(nameToastMsg);
		Assert.assertEquals("Please enter your name", nameToastMsg);
		
		
		
	}

}
