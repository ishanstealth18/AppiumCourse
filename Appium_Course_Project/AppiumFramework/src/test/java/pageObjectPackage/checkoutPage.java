package pageObjectPackage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class checkoutPage {
	
	public checkoutPage(AppiumDriver checkOutPageDriver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(checkOutPageDriver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> prodName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> prodCart;

}
