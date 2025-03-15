package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity1 {
    // Declare the class object
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
    //Driver initialization
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://v1.training-support.net");
    }

    @Test (priority = 1)
    public void pageTitleTest() {
        // Verifying title of the page
        assertEquals(driver.getTitle(), "Training Support");
    }
    
    @Test (priority = 2)
    public void aboutLinkTest() {
        // Find about page link and click it
    	driver.findElement(By.linkText("About Us")).click();
    	//Verify page direct
    	assertEquals(driver.getTitle(), "About Training Support");
    	
    }

    @AfterClass //Teardown function
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
