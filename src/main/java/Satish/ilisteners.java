package Satish;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ilisteners implements ITestListener {

    public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("on to success");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("on test Skipped");
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("on test failedwithTimeout");
		
	}

	public void onStart(ITestContext context) {
		System.out.println("on start");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


 }
