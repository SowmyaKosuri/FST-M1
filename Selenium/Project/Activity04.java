package SeleniumProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Activity04 extends BaseClass {

    @Test
    public void LoginTest() {
    	
    	Reporter.log("Activity04 -> Test Login Functionality", true);

		driver.findElement(By.xpath("//div/input[@tabindex='1']")).sendKeys("admin");
		driver.findElement(By.xpath("//div/input[@tabindex='2']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//form/input[@tabindex='3']")).click();

		// Verify that after login we are in the dashboard.
		// We can check by verifying the Tab name to "SUITECRM DASHBOARD"
		WebElement dashboardTab = driver.findElement(By.id("tab0"));
		String dashboardTabText = dashboardTab.getText();
		Assert.assertEquals(dashboardTabText, "SUITECRM DASHBOARD");
	}

}
