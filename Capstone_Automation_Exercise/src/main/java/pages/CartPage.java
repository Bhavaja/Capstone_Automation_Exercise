package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	// **************** Locators **************** //
	By addToCartButton = By.cssSelector("button.btn.btn-default.cart");
	By viewCartButton = By.cssSelector("div.modal-content a[href='/view_cart']");
	By proceedToCheckoutButton = By.cssSelector("a.btn.btn-default.check_out");
	
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        this.js = (JavascriptExecutor) driver;
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickAddToCart() {
    	//wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    	driver.findElement(addToCartButton).click();
    }
    
    public void clickViewCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
    	driver.findElement(viewCartButton).click();
    }
    
    /*public void clickCheckout() {
    	//wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
    	driver.findElement(proceedToCheckoutButton).click();
    }
    
    public void scrollDown() {
    	js.executeScript("window.scrollBy(0,300)");
    }*/
    
    
   
    

}
