package tlistaner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("********** onTestStart"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("********** onTestSuccess"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("********** onTestFailure"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("********** onTestSkipped"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("********** TestFailedButWithinSuccessPercentage"+result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("********** onTestFailedWithTimeout"+result.getName());;
	}

	public void onStart(ITestContext context) {
		System.out.println("********** onStart"+context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("********** onFinish"+context.getName());
	}

}
