package BasePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class dragAndDrop extends base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> drivers = capabilities("real");
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		drivers.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		WebElement Point1 = drivers.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement Point2 = drivers.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		TouchAction t = new TouchAction(drivers);
		t.longPress(longPressOptions().withElement((element(Point1)))).perform();
		t.moveTo((element(Point2))).perform().release();
		
		

	}

}
