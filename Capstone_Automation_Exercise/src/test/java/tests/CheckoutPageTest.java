package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import utils.ConfigReader;

public class CheckoutPageTest {
	
	public WebDriver driver;
	CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        checkoutPage = new CheckoutPage(driver);

    }
    
    //checkout after logging in
    @Test(priority = 1)
    public void checkoutWithLogin() throws InterruptedException {
    	checkoutPage.openUrl(ConfigReader.getProperty("loginUrl")); 
    	checkoutPage.enterValidEmail("lucifer@gmail.com");
    	checkoutPage.enterValidPassword("DaisyMom@123");
    	checkoutPage.clickLogin();
    	checkoutPage.clickCart();
    	Thread.sleep(2000);
    	checkoutPage.clickCheckout();
    	String checkoutTitle = driver.getTitle();
        Assert.assertTrue(checkoutTitle.toLowerCase().contains("checkout"), 
                "Checkout page did not load. Current title: " + checkoutTitle);
    	checkoutPage.clickLogout();
    	
    }
    
    //checkout without logging in
    @Test(priority = 2)
    public void checkoutWithoutLogin() throws InterruptedException {
    	checkoutPage.openUrl(ConfigReader.getProperty("productsUrl")); 
    	checkoutPage.clickAddToCart();
    	checkoutPage.clickViewCart();
		Thread.sleep(2000);
    	checkoutPage.clickCheckout();
    	checkoutPage.clickRegisterLogin();
    	Assert.assertTrue(driver.getTitle().toLowerCase().contains("login"),
    	            "Page title does not contain 'login'");
    }
    
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  
}
