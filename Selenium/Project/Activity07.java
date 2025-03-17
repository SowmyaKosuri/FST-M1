package SeleniumProject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity07 extends BaseClassLogin {
	@Test
	public void SalesToLeadsMenuItem() {
		Reporter.log("Activity07 -> Find available leads phone numbers", true);

		WebElement salesNavigationOption = driver.findElement(By.id("grouptab_0"));
		salesNavigationOption.click();
		WebElement leadsOption = driver.findElement(By.id("moduleTab_9_Leads"));
		leadsOption.click();

		Reporter.log("Waiting for the page to load");

		// Wait for the page to load and show the LEADS label above the table
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='module-title-text']"),
				"LEADS"));

		Reporter.log("Waiting for the LEADS table to load");
		// Wait for the table to load with atleast 1 row
		wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//table[@class='list view table-responsive']/tbody/tr"), 1));

		// Now that the table is visible, we can get the total cells with "i"
		// xpath is //span[@class='suitepicon suitepicon-action-info']
		List<WebElement> allCellsWithI = driver
				.findElements(By.xpath("//td/span/span[@title='Additional Details']"));
		for (Iterator<WebElement> iterator = allCellsWithI.iterator(); iterator.hasNext();) {
			WebElement cell = (WebElement) iterator.next();
			cell.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				WebElement visiblePhoneText = driver.findElement(By.xpath(
						"//div[contains(@class,'ui-dialog ui-widget ui-widget-content') and contains(@style,'display: block')]//span[@class='phone']"));
				Reporter.log("Phone number is: " + visiblePhoneText.getText(), true);

			} catch (NoSuchElementException e) {
				Reporter.log("Phone field is not present in DOM", true);
			}
		}
	}
  
}
