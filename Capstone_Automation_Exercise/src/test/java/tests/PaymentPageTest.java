package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.PaymentPage;
import utils.ConfigReader;

public class PaymentPageTest {
	
	public WebDriver driver;
	PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        paymentPage = new PaymentPage(driver); 
    }
    
    //payment
    @Test
    public void paymentTest() throws InterruptedException {
    	paymentPage.openUrl(ConfigReader.getProperty("loginUrl")); 
    	paymentPage.enterValidEmail("lucifer@gmail.com");
    	paymentPage.enterValidPassword("DaisyMom@123");
    	paymentPage.clickLogin();
    	paymentPage.clickCart();
    	Thread.sleep(2000);
    	paymentPage.clickCheckout();
    	paymentPage.scrollDown();
    	paymentPage.clickplaceOrder();
    	paymentPage.enterNameOnCard("Lucifer");
    	paymentPage.enterCardNumber("123456789");
    	paymentPage.enterCvc("311");
    	paymentPage.enterExpiryMonth("10");
    	paymentPage.enterExpiryYear("2030");
    	paymentPage.payAndConfirmOrder();
    	String actualMessage = paymentPage.OrderConfirmMessage();
    	Assert.assertEquals(actualMessage, "ORDER PLACED!");
    	
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  
}
