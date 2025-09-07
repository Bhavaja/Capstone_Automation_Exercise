package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.ConfigReader;

public class HomePageTest{
  
	WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver); 
    }
    
    @BeforeMethod
    public void navigateBackToHome() {
    	homePage.openUrl(ConfigReader.getProperty("homePageUrl"));
    }
    
    @Test
    public void verifySignUpLoginButtonClickable() {
        homePage.clickSignupLogin();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("login"),
                "Page title does not contain 'login'");
    }

    @Test
    public void verifyProductsPageNavigation() {
    	//driver.navigate().to("https://automationexercise.com/");
    	homePage.clickProducts();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("products"),
                "Page title does not contain 'products'");
    }
    
    @Test
    public void verifyCartPageNavigation() {
    	//driver.navigate().to("https://automationexercise.com/");
    	homePage.clickCart();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("checkout"),
                "Page title does not contain 'checkout'");
    }
    
    @Test
    public void verifyContactUsPageNavigation() {
    	//driver.navigate().to("https://automationexercise.com/");
    	homePage.clickContactUs();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("contact us"),
                "Page title does not contain 'contact us'");
    }
    
    @Test
    public void verifyTestCasesPageNavigation() {
    	//driver.navigate().to("https://automationexercise.com/");
    	homePage.clickTestCases();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("test cases"),
                "Page title does not contain 'test cases'");
    }
    
    @Test
    public void verifyApiTestingPageNavigation() {
    	//driver.navigate().to("https://automationexercise.com/");
    	homePage.clickApiTesting();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("api testing"),
                "Page title does not contain 'api testing'");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
