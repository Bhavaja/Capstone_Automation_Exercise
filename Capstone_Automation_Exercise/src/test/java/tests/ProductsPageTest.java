package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ProductsPage;
import utils.ConfigReader;

public class ProductsPageTest {
  
	public WebDriver driver;
	ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        productsPage = new ProductsPage(driver);
        productsPage.openUrl(ConfigReader.getProperty("homePageUrl")); 
    }
    
    //select product by category
    @Test(priority = 1)
    public void productDetailsTest() throws InterruptedException {
    	productsPage.clickProducts();
    	productsPage.scrollDown();
    	productsPage.selectCategory();
    	productsPage.selectSubCategory();
    	productsPage.scrollDown();
    	productsPage.viewFirstProduct();
    	Assert.assertTrue(driver.getTitle().toLowerCase().contains("product details"),
                "Page title does not contain 'product details'");
    }
    
    //search for product
    @Test(priority = 2)
    public void productDetailsSearchTest() throws InterruptedException {
    	productsPage.clickProducts();
    	productsPage.scrollDown();
    	productsPage.searchBarText("Dress");
    	productsPage.clickSearchButton();
    	productsPage.scrollDown();
    	productsPage.viewFirstProduct();
    	Assert.assertTrue(driver.getTitle().toLowerCase().contains("product details"),
                "Page title does not contain 'product details'");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
