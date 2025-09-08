package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	// **************** Locators **************** //
	By loginEmail = By.cssSelector("input[data-qa='login-email']");
	By loginPassword = By.cssSelector("input[data-qa='login-password']");
	By loginButton = By.cssSelector("button[data-qa='login-button']");
	
	By cartLink = By.xpath("//a[contains(text(),'Cart')]");
	
	By addToCartButton = By.cssSelector("button.btn.btn-default.cart");
	By viewCartButton = By.cssSelector("div.modal-content a[href='/view_cart']");
	By proceedToCheckoutButton = By.cssSelector("a.btn.btn-default.check_out");
	
	By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
	
	By registerLoginLink = By.xpath("//u[contains(text(),'Register / Login')]");

    public CheckoutPage(WebDriver driver) {
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
    
    public void clickLogout() {
    	wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
    	driver.findElement(logoutLink).click();
    }
    
    public void scrollDown() {
    	js.executeScript("window.scrollBy(0,300)");
    }
    
    public void clickAddToCart() {
    	//wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    	driver.findElement(addToCartButton).click();
    }
    
    public void clickViewCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
    	driver.findElement(viewCartButton).click();
    }
    
    public void clickRegisterLogin() {
    	//wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    	driver.findElement(registerLoginLink).click();
    }

}
