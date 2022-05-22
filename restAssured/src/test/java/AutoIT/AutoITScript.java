package AutoIT;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITScript {
@Test
public void test() throws Exception {
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	driver.get("https://ufile.io/");
	driver.findElement(By.xpath("//form[@id='upload-window']")).click();
	Runtime.getRuntime().exec("D:\\FileuploadScript.exe");
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			  public WebElement apply(WebDriver driver) {
			    WebElement linkElement =  driver.findElement(By.id("copylink"));
			  if (linkElement.isEnabled()) {
				System.out.println("link enabled");
			}
			  return linkElement;
			  
			  }});

}
}
