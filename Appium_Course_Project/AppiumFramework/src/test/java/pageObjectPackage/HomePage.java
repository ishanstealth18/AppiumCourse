package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//All objects belonging to same page will be define in 1 java class
public class HomePage {
	
	//Creating a constructor to initialize driver(basic class) elements
	public HomePage(AppiumDriver d) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement preferences;
	
	

}
