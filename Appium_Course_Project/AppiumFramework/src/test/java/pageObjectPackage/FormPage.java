package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AppiumDriver formPageDriver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(formPageDriver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement femaleRadioBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement country;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement prodName;
	
	
	
	
	
	

}
