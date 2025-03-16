package SeleniumProject;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

public class Activity01 extends BaseClass{
	 @Test
	    public void pageTitleTest() {
		 Reporter.log("Activity01 -> Validate the page title", true);
		  String pageTitle = driver.getTitle();
		  Reporter.log("Page title is: " + pageTitle, true);
		  
		  Assert.assertEquals(pageTitle, "SuiteCRM");
	    }
    }