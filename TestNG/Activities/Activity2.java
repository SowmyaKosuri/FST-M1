package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;


public class Activity2 {
	// Declare the class object
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
    //Driver initialization
        driver = new FirefoxDriver();
            
        //Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    
    @Test
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        assertEquals(title, "Target Practice");
    }
    
    @Test
    public void testCase2() {
        //This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        assertTrue(blackButton.isDisplayed());
        assertEquals(blackButton.getText(), "black");
    }
    
    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        assertTrue(subHeading.contains("Practice"));
    }
    
    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");      
    }

    @AfterClass //Teardown function
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}