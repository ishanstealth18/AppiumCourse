package testNGPackage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testClass4 {
	
	@Test(groups = {"smoke"})
	public void demo4()
	{
		System.out.println("This is class4 : demo 4");
	}
	
	@Test(groups = {"smoke"})
	public void demo5()
	{
		System.out.println("This depends on aDemo6");
		System.out.println("This is class4 : demo 5");
	}
	
	@Test(groups = {"smoke"})
	public void demo6()
	{
		System.out.println("This is class4 : demo 6");
	}

	@BeforeTest
	public void preReq()
	{
		System.out.println("This is pre req class 4");
	}
}
