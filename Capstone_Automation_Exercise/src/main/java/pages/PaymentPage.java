package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	// **************** Locators **************** //
	By loginEmail = By.cssSelector("input[data-qa='login-email']");
	By loginPassword = By.cssSelector("input[data-qa='login-password']");
	By loginButton = By.cssSelector("button[data-qa='login-button']");
	
	By cartLink = By.xpath("//a[contains(text(),'Cart')]");
	By proceedToCheckoutButton = By.cssSelector("a.btn.btn-default.check_out");
	
	By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
	
	By nameOnCard = By.name("name_on_card");
	By cardNumber = By.name("card_number");
	By cvcField = By.cssSelector("input[data-qa='cvc']");
	By expiryMonthField = By.cssSelector("input[data-qa='expiry-month']");
	By expiryYearField = By.cssSelector("input[data-qa='expiry-year']");
	By payAndConfirmOrderButton = By.cssSelector("button[data-qa='pay-button']");
	By orderPlacedMessage = By.xpath("//h2[@data-qa='order-placed']");
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        this.js = (JavascriptExecutor) driver;
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
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
    
    public void clickCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(cartLink).click();   
    }
    
    public void clickCheckout() {
    	wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
    	driver.findElement(proceedToCheckoutButton).click();
    }
    
    public void scrollDown() {
    	js.executeScript("window.scrollBy(0,800)");
    }
    
    public void clickplaceOrder() {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(placeOrderButton).click();   
    }
    
    public void enterNameOnCard(String name) {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(nameOnCard).sendKeys(name);   
    }
    
    public void enterCardNumber(String number) {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(cardNumber).sendKeys(number);   
    }
    
    public void enterCvc(String cvc) {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(cvcField).sendKeys(cvc);   
    }
    
    public void enterExpiryMonth(String month) {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(expiryMonthField).sendKeys(month);   
    }
    
    public void enterExpiryYear(String year) {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(expiryYearField).sendKeys(year);   
    }
    
    public void payAndConfirmOrder() {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(payAndConfirmOrderButton).click();  
    }
    
    public String OrderConfirmMessage() {
    	String message = driver.findElement(orderPlacedMessage).getText();
    	return message;
    }
    
}
