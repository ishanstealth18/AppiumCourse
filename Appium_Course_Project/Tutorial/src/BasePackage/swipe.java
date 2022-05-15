package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.touch.offset.ElementOption;

public class swipe extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> drivers = capabilities("real");
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		Thread.sleep(2000);
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		Thread.sleep(2000);
		drivers.findElement(By.xpath("//*[@content-desc='9']")).click();
		
		//Touch actions
		TouchAction t = new TouchAction(drivers);
		
		WebElement fromTime = drivers.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement toTime = drivers.findElement(By.xpath("//*[@content-desc='45']"));
		t.longPress(longPressOptions().withElement(element(fromTime))).perform();
		t.moveTo(element(toTime)).perform();
		
		
	}

}
