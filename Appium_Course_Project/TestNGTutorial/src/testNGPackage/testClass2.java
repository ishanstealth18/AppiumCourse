package testNGPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testClass2 {
	
	
	@BeforeTest
	public void preReq()
	{
		System.out.println("This is pre req");
	}
	
	@Test
	public void demo()
	{
		System.out.println("hello2");
	}

	@AfterTest
	public void afterDemo()
	{
		System.out.println("Execute after test2");
	}
}
