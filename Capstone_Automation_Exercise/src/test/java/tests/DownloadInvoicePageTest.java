package tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DownloadInvoicePage;
import utils.ConfigReader;

public class DownloadInvoicePageTest {
	
	public WebDriver driver;
	DownloadInvoicePage downloadInvoicePage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        downloadInvoicePage = new DownloadInvoicePage(driver);
        downloadInvoicePage.openUrl(ConfigReader.getProperty("downloadInvoiceUrl")); 
    }
   
    //download invoice
    @Test(priority = 1)
    public void downloadInvoiceTest() throws InterruptedException {
    	downloadInvoicePage.clickDownloadInvoice();
    	Thread.sleep(3000);
    	String downloadPath = System.getProperty("user.home") + "/Downloads/";
        File downloadedFile = new File(downloadPath + "invoice.txt");  // or invoice.pdf based on site
        
        Assert.assertTrue(downloadedFile.exists(), "Invoice file was not downloaded!");
    	
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  
}
