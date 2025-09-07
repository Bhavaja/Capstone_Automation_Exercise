package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import utils.ConfigReader;

public class CartPageTest {
	
	public WebDriver driver;
	CartPage cartPage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cartPage = new CartPage(driver);
        cartPage.openUrl(ConfigReader.getProperty("productsUrl")); 
    }
    
    //scroll down 
    @Test(priority = 1)
    public void addToCart() throws InterruptedException {
    	cartPage.clickAddToCart();
    	cartPage.clickViewCart();
    	boolean productAdded = driver.findElement(By.xpath("//tbody/tr")).isDisplayed();
        Assert.assertTrue(productAdded, "Product was not added to cart!");
    }
    
    
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  
}
