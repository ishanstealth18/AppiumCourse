package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import AppiumPractice.AppiumFramework.base;

public class Listeners implements ITestListener{
	
	public String failedResult;
	public String failedTestName;
	public String PassedResult;
	public String passedTestName;
	
	base baseObj = new base();
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Inside Failed Result Method");
		failedResult = result.getName();
		System.out.println("Failed Test Result : " +failedResult);
		failedTestName =  result.getTestName();
		System.out.println("Failed Test Name : " +failedTestName);
		try {
			baseObj.getScreenshot(failedResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Inside Passed Result Method");
		PassedResult = result.getName();
		System.out.println("Passed Test Result : " +PassedResult);
		passedTestName =  result.getTestName();
		System.out.println("Passed Test Name : " +passedTestName);
		try {
			baseObj.getScreenshot(PassedResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
