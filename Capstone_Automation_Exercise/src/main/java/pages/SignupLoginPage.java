package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SignupLoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// **************** Locators **************** //
	By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
	By newNameField = By.name("name");
	By newEmailField = By.xpath("//form[@action='/signup']/input[3]");
	By signupButton = By.xpath("//form[@action='/signup']/button");
   
	By newPassword = By.id("password");
	By selectDay = By.id("days");
	By selectMonth = By.id("months");
	By selectYear = By.id("years");
	By firstName = By.id("first_name");
	By lastName = By.id("last_name");
	By address = By.id("address1");
	By countryDropdown = By.id("country");
	By State = By.id("state");
	By City = By.id("city");
	By Zipcode = By.id("zipcode");
	By mobile_number = By.id("mobile_number");
	By createAccountButton = By.xpath("//button[@type='submit']");
	By accountCreatedHeading = By.xpath("//h2[contains(., 'Account Created!')]");
	By userAlreadyExistsMsg = By.xpath("//p[contains(text(),'Email Address already exist!')]");
	
	By loginEmail = By.cssSelector("input[data-qa='login-email']");
	By loginPassword = By.cssSelector("input[data-qa='login-password']");
	By loginButton = By.cssSelector("button[data-qa='login-button']");
	By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
	By invalidLoginMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
	
	By logoutLink = By.xpath("//a[contains(text(),'Logout')]");

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
    }
    
    public void clickSignupLogin() {
    	//wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink));
    	driver.findElement(signupLoginLink).click();
    }

    public void enterNewName(String newName) {
    	//wait.until(ExpectedConditions.elementToBeClickable(newNameField));
    	driver.findElement(newNameField).sendKeys(newName);
    }
    
    public void enterNewEmail(String newEmail) {
    	//wait.until(ExpectedConditions.elementToBeClickable(newEmailField));
    	driver.findElement(newEmailField).sendKeys(newEmail);
    }
    
    public void clickSignup() {
    	//wait.until(ExpectedConditions.elementToBeClickable(signupButton));
    	driver.findElement(signupButton).click();
    }
    
    public void enternewPassword(String pass) {
    	//wait.until(ExpectedConditions.elementToBeClickable(newPassword));
    	driver.findElement(newPassword).sendKeys(pass);
    }
    
    public void selectDOB(String day, String month, String year) {
    	//wait.until(ExpectedConditions.elementToBeClickable(selectDay));
    	WebElement chooseDay = driver.findElement(selectDay);
		Select Day = new Select(chooseDay);
		Day.selectByVisibleText(day);
		WebElement chooseMonth = driver.findElement(selectMonth);
		Select Month = new Select(chooseMonth);
		Month.selectByVisibleText(month);
		WebElement chooseYear = driver.findElement(selectYear);
		Select Year = new Select(chooseYear);
		Year.selectByVisibleText(year); 	
    }
    
    public void enterFirstName(String fname) {
    	//wait.until(ExpectedConditions.elementToBeClickable(firstName));
    	driver.findElement(firstName).sendKeys(fname);
    }
    
    public void enterLastName(String lname) {
    	//wait.until(ExpectedConditions.elementToBeClickable(lastName));
    	driver.findElement(lastName).sendKeys(lname);
    }
    
    public void enterAddress(String addr) {
    	//wait.until(ExpectedConditions.elementToBeClickable(address));
    	driver.findElement(address).sendKeys(addr);
    }
    
    public void selectCountry(String country) {
    	//wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
    	WebElement chooseCountry = driver.findElement(countryDropdown);
		Select Country = new Select(chooseCountry);
		Country.selectByVisibleText(country); 
    }
    
    public void enterState(String state) {
    	//wait.until(ExpectedConditions.elementToBeClickable(State));
    	driver.findElement(State).sendKeys(state);
    }
    
    public void enterCity(String city) {
    	//wait.until(ExpectedConditions.elementToBeClickable(City));
    	driver.findElement(City).sendKeys(city);
    }
    
    public void enterZipcode(String zipcode) {
    	//wait.until(ExpectedConditions.elementToBeClickable(Zipcode));
    	driver.findElement(Zipcode).sendKeys(zipcode);
    }
    
    public void enterMobileNumber(String number) {
    	//wait.until(ExpectedConditions.elementToBeClickable(mobile_number));
    	driver.findElement(mobile_number).sendKeys(number);
    }
    
    public void clickCreateAccount() {
    	//wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
    	driver.findElement(createAccountButton).click();
    }
    
    public String accountCreatedMessage() {
    	//wait.until(ExpectedConditions.elementToBeClickable(accountCreatedHeading));
    	String msg = driver.findElement(accountCreatedHeading).getText();
    	return msg;
    }
    
    public String userAlreadyExistsMessage() {
    	//wait.until(ExpectedConditions.elementToBeClickable(userAlreadyExistsMsg));
    	String msg = driver.findElement(userAlreadyExistsMsg).getText();
    	return msg;
    }
    
    public void enterValidEmail(String email) {
    	//wait.until(ExpectedConditions.elementToBeClickable(loginEmail));
    	driver.findElement(loginEmail).sendKeys(email);
    }
    
    public void enterValidPassword(String pass) {
    	//wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
    	driver.findElement(loginPassword).sendKeys(pass);
    }
    
    public void clickLogin() {
    	//wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    	driver.findElement(loginButton).click();
    }
    
    public String loginSuccessfulMessage() {
    	//wait.until(ExpectedConditions.elementToBeClickable(loggedInUser));
    	String msg = driver.findElement(loggedInUser).getText();
    	return msg;
    }
    
    //login with invalid user
    public String invalidLoginMessage() {
    	//wait.until(ExpectedConditions.elementToBeClickable(invalidLoginMsg));
    	String msg = driver.findElement(invalidLoginMsg).getText();
    	return msg;
    }
    
    public void clickLogout() {
    	//wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
    	driver.findElement(logoutLink).click();
    }
    
    
}
