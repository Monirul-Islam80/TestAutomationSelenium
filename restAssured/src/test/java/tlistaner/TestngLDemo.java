package tlistaner;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestngLDemo {
	@Test(priority = 5)
	public void test1() {
		System.out.println("this is test 1 ......");
	}
	@Test(priority = 4)
	public void test2() {
		System.out.println("this is test 2 ......");
	}
	@Test(priority = 3, retryAnalyzer = analyzers.RetryAnalyzer.class)
	public void test3() {
		int l = 3/0;
		System.out.println("this is test 3 ......");
	}
	@Test(priority = 2)
	public void test4() {
		SoftAssert s = new SoftAssert();
		s.assertEquals(true, false);
		System.out.println("this is test 4......");
s.assertAll();
	}
	@Test(priority = 1)
	public void test5() {
		System.out.println("this is test 5 ......");
		throw new SkipException("this is skipped");
	}
}
