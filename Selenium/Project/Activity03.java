package SeleniumProject;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Activity03 extends BaseClass{
  @Test
  public void copyrightTextTest() {
	    Reporter.log("Activity03 -> Print the first Copyright Text", true);

		WebElement Firstcopyright = driver.findElement(By.xpath("//a[@id='admin_options']"));
		String copyrightText = Firstcopyright.getText();

		Reporter.log("Copyright Text is: " + copyrightText, true);
  }

}
