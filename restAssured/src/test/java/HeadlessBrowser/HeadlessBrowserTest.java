package HeadlessBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowserTest {
@Test
public void test1 () {
	WebDriver driver;
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	driver.get("https://google.com");
WebElement t = 	driver.findElement(By.xpath("(//div[@class='uU7dJb'])[1]"));
String p = t.getText().toString();
System.out.println(p);
}
}
