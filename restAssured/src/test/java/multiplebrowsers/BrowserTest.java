package multiplebrowsers;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserTest {
	WebDriver driver;
@Parameters("browserName")
@BeforeTest
public void setUp(@Optional("chrome") String browserName) {
	System.out.println("Browser: "+ browserName);
	System.out.println("thread no: "+Thread.currentThread().getId());	
	System.out.println("thread no: "+Thread.currentThread().getName());
	if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}else	if (browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}else	if (browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}else {
		System.out.println("no browser");
	}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
}
@Test
public void test1() throws Exception {
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("abcd");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(5))
		.ignoring(NoSuchElementException.class);
	WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		  public WebElement apply(WebDriver driver) {
		    WebElement linkElement =  driver.findElement(By.cssSelector("a[href='https://apps.apple.com/us/app/abcd-alphabet-songs-for-kids/id1145350560']"));
		  if (linkElement.isEnabled()) {
			System.out.println("link enabled");
		}
		  return linkElement;
		  
		  }});
	element.click();
}
@AfterTest
private void teardown() {
	driver.close();
	System.out.println("test complite");
}
}
