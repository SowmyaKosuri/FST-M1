package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        // Initialize wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //Open browser
        driver.get("https://training-support.net/webelements/login-form");
    }
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "password" }};
    }
    
    @Test (dataProvider = "Authentication")
    public void loginTestCase(String username, String password, String expectedMessage) {
        //Find username and password fields
        WebElement usernameField = driver.findElement(By.id("Username"));
        WebElement passwordField = driver.findElement(By.id("Password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        
        
        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        /
        //Assert Message
        String loginMessage = driver.findElement(By.id("action-subheading")).getText();
        assertEquals(loginMessage, expectedMessage);
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}