package analyzers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
private int retryCount = 0;
private int MaxRetryCount = 3;
	public boolean retry(ITestResult result) {
if (retryCount<MaxRetryCount) {
	retryCount++;
	return true;
}
		return false;
	}

}
