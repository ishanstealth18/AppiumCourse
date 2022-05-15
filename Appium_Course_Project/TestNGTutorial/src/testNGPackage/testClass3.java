package testNGPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testClass3 {

	@Test
	public void demo1()
	{
		System.out.println("This is 3rd class: demo1");
	}
	
	@Parameters({"APK"})
	@Test(groups = {"smoke"})
	public void demo2(String apkName)
	{
		System.out.println("APK name: " +apkName);
		System.out.println("This is 3rd class: demo2");
	}
	
	@Test
	public void demo3()
	{
		System.out.println("This is 3rd class: demo3");
	}
}
