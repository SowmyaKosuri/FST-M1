package SeleniumProject;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Activity02 extends BaseClass{
    @Test
    public void imageURLTest() {
    	Reporter.log("Activity02 -> Print HeaderImage URL", true);

		WebElement image = driver.findElement(By.xpath("//div/img[@alt='SuiteCRM']"));
		String imageURL = image.getDomAttribute("src");

		Reporter.log("URL of the header image on login page is: " + imageURL, true);
    }
}
