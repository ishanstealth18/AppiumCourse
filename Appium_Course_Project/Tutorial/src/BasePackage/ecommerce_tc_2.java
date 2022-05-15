package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_2 extends base{

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
		//Thread.sleep(5000);
		
		//Scroll functions
				drivers.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
						".scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))"));
				Thread.sleep(3000);
		//One way to find the element from long list
		/**		
		drivers.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='2']"
				+ "/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='1']")).click();
		**/
				
		//Another way to find element from list dynamically
				
		int listCount = drivers.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(listCount);
		
		
		//Logic to find element dynamically from list without using scroll
		for(int i = 0 ;i<=listCount; i++)
		{
			String tileText = drivers.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(tileText);
			if(tileText.equals("Jordan 6 Rings"))
			{
				System.out.println("Inside If");
				drivers.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		
		drivers.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).isDisplayed();
		drivers.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']")).isDisplayed();
	}

}
