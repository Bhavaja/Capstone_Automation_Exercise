package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SignupLoginPage;
import utils.ConfigReader;



public class SignupLoginPageTest {
  
	WebDriver driver;
	SignupLoginPage signupLoginPage;

    @BeforeClass
    public void setUp() {
    	ConfigReader.loadProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        signupLoginPage = new SignupLoginPage(driver); 
    }
    
    @BeforeMethod
    public void navigateBackToHome() {
    	signupLoginPage.openUrl(ConfigReader.getProperty("loginUrl"));
    }
    
    //signup with new user
    @Test(priority = 1)
    public void signupNewUser() throws InterruptedException {
    	//signupLoginPage.clickSignupLogin();
    	signupLoginPage.enterNewName("Me");
    	signupLoginPage.enterNewEmail("me@gmail.com");
    	signupLoginPage.clickSignup();
    	/*Assert.assertTrue(driver.getTitle().toLowerCase().contains("signup"),
                "User is not navigated to signup page'");*/
    	signupLoginPage.enternewPassword("Me@123");
    	signupLoginPage.selectDOB("21", "June", "1996");
    	signupLoginPage.enterFirstName("Me");
    	signupLoginPage.enterLastName("Sharma");
    	signupLoginPage.enterAddress("Abc colony");
    	signupLoginPage.selectCountry("India");
    	signupLoginPage.enterState("Andhra Pradesh");
    	signupLoginPage.enterCity("Tirupati");
    	signupLoginPage.enterZipcode("517503");
    	signupLoginPage.enterMobileNumber("9876543210");
    	signupLoginPage.clickCreateAccount();
    	Thread.sleep(2000);
    	String expectedMsg = "ACCOUNT CREATED!";
    	Assert.assertEquals(expectedMsg,signupLoginPage.accountCreatedMessage());
    	
    	//signupLoginPage.clickLogout();
    }
    
    //signup with existing user
    @Test(priority = 2)
    public void signupExistingUser() throws InterruptedException {
    	signupLoginPage.clickLogout();
    	signupLoginPage.clickSignupLogin();
    	signupLoginPage.enterNewName("Diana");
    	signupLoginPage.enterNewEmail("diana@gmail.com");
    	signupLoginPage.clickSignup();
    	String expectedMsg = "Email Address already exist!";
    	Assert.assertEquals(expectedMsg,signupLoginPage.userAlreadyExistsMessage());
    	Thread.sleep(2000);
    }
    
    //login with valid user
    @Test(priority = 4)
    public void loginValidUser() throws InterruptedException {
    	//signupLoginPage.clickSignupLogin();
    	signupLoginPage.enterValidEmail("diana@gmail.com");
    	signupLoginPage.enterValidPassword("Dimple@123");
    	signupLoginPage.clickLogin();
    	String loggedInText = signupLoginPage.loginSuccessfulMessage();
    	Assert.assertTrue(loggedInText.contains("Logged in as"),
    	        "Login failed. Expected 'Logged in as' but found: " + loggedInText);
    	Thread.sleep(2000);

    }
    
    //login with invalid user
    @Test(priority = 3)
    public void loginInvalidUser() throws InterruptedException {
    	//signupLoginPage.clickSignupLogin();
    	signupLoginPage.enterValidEmail("maxy@gmail.com");
    	signupLoginPage.enterValidPassword("Maxy@123");
    	signupLoginPage.clickLogin();
    	String expectedMsg = "Your email or password is incorrect!";
    	Assert.assertEquals(expectedMsg,signupLoginPage.invalidLoginMessage());
    	Thread.sleep(2000);

    	
    	
    }
    /*@Test
    public void createNewUser() {
    	signupLoginPage.clickSignupLogin();
    	signupLoginPage.enterNewName("Dimple");
    	signupLoginPage.enterNewEmail("dimple@gmail.com");
    	signupLoginPage.clickSignup();
    	Assert.assertTrue(driver.getTitle().toLowerCase().contains("signup"),
                "User is not navigated to signup page'");
    }*/
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
   
}
