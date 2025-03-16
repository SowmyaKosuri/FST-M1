package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity05 extends BaseClassLogin{
	@Test
	public void testNavigationMenuColor() {
		Reporter.log("Activity05 -> Print Navigation Menu Color", true);

		WebElement navigationbar = driver.findElement(By.xpath("//nav[contains(@class,'navbar')]"));
		String menuColor = navigationbar.getCssValue("color");
		Color headerColor = Color.fromString(menuColor);
		Reporter.log("Color of the Navigation bar in HEX is: " + headerColor.asHex(), true);
		Reporter.log("Color of the Navigation bar in RGB is: " + headerColor.asRgb(), true);
		Assert.assertEquals(headerColor.asHex(), "#534d64");
	}

}
