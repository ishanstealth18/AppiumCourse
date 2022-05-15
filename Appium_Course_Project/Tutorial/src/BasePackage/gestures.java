package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class gestures extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stubn
		
		AndroidDriver<AndroidElement> drivers = capabilities("real");
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		
		WebElement peopleName = drivers.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		TouchAction longPressAction = new TouchAction(drivers);
		longPressAction.longPress(longPressOptions().withElement(element(peopleName))).perform();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed();
		
	}

}
