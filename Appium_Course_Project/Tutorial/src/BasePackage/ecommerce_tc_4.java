package BasePackage;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_4 extends base{

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> drivers = capabilities("emulator");
		Thread.sleep(3000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/nameField")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		drivers.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ishan");
		drivers.hideKeyboard();
		
		Thread.sleep(3000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(3000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		Thread.sleep(3000);
		
		//Scroll functions
		drivers.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\"Argentina\"))")).click();
		Thread.sleep(3000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Scroll functions
		drivers.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))"));
		Thread.sleep(3000);
		
		
		//Another way to find element from list dynamically
		
		int listCount = drivers.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(listCount);
		
		
		//Logic to find element dynamically from list without using scroll
		for(int i = 0 ;i<listCount; i++)
		{	
			
			String tileText = drivers.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(tileText);
			drivers.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			Thread.sleep(3000);
		}
		
	
		
		drivers.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).isDisplayed();
		drivers.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
		Thread.sleep(2000);
		
		WebElement termsLink = drivers.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		
		TouchAction longPressAction = new TouchAction(drivers);
		longPressAction.longPress(longPressOptions().withElement(element(termsLink))).perform();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//*[@text='CLOSE']")).click();
		Thread.sleep(2000);
		drivers.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
		
			
		
	}

}
