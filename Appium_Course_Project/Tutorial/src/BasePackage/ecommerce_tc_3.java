package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_3 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
				
				int totalProductListSize = drivers.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
				System.out.println("Total products: " +totalProductListSize);
				
				
				double totalAmt = 0;
				String tempStr = null;
				double tempAmt = 0;
				for(int i = 0 ;i<totalProductListSize; i++)
				{
					tempStr = drivers.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
					tempAmt = getAmount(tempStr);
					totalAmt = totalAmt + tempAmt;
				}
				System.out.println("Total Price : " +totalAmt);
				
				String tempExpectedAmt = drivers.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();  
				double expectedAmt = getAmount(tempExpectedAmt);
				Assert.assertEquals(totalAmt, expectedAmt);
	}
	
	public static double getAmount(String amountText)
	{	
		double currenAmt = 0;
		amountText = amountText.replace("$", "");
		System.out.println("Amount " +" " +amountText);
		currenAmt = Double.parseDouble(amountText);
		System.out.println("Amount in integer: " +currenAmt);	
		return currenAmt;
	}
}
