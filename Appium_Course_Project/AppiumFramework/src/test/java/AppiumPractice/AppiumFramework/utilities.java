package AppiumPractice.AppiumFramework;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class utilities {
	
	AndroidDriver dr;	
	public utilities(AndroidDriver utilDriver)
	{
		this.dr = utilDriver;
	}
	
	public void scrollToText(String scrollText)
	{
		dr.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\"" +scrollText +"\"))")).click();
	}

}
