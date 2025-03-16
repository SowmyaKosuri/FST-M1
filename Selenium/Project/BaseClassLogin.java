package SeleniumProject;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BaseClassLogin {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/crm");
		
		driver.findElement(By.xpath("//div/input[@tabindex='1']")).sendKeys("admin");
		driver.findElement(By.xpath("//div/input[@tabindex='2']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//form/input[@tabindex='3']")).click();
	}

	@AfterClass
	public void afterClass() {
		// Tear down
		driver.quit();
	}

}