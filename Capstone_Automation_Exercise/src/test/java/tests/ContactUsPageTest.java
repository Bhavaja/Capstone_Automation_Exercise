package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import utils.ConfigReader;

public class ContactUsPageTest {
	
	public WebDriver driver;
	ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        contactUsPage = new ContactUsPage(driver);

        // Open homepage
        contactUsPage.openUrl(ConfigReader.getProperty("contactUsUrl")); 
    }
   
    //download invoice
    @Test(priority = 1)
    public void downloadInvoiceTest() throws InterruptedException {
    	contactUsPage.enterName("Dexter");
    	contactUsPage.enterEmail("dexter@gmail.com");
    	contactUsPage.enterSubject("Delivery update");
    	contactUsPage.enterMessage("My order is not delivered yet");
    	contactUsPage.clickSubmit();
    	contactUsPage.handleAlert();
    	String successMsg = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
    	Assert.assertTrue(successMsg.contains("Success"), "Form submission failed!");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  
}
