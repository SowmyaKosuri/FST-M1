package SeleniumProject;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Activity06 extends BaseClassLogin{
	@Test
	public void isActivitiesOptionDisplayed() {
		Reporter.log("Activity06 -> Activities option displayed or not", true);

		WebElement ActivitiesOption = driver.findElement(By.id("grouptab_3"));
		String ActivitiesOptionText = ActivitiesOption.getText();
		Reporter.log("Activities option Text: " + ActivitiesOptionText, true);
		Assert.assertEquals(ActivitiesOptionText, "ACTIVITIES");
	}
}