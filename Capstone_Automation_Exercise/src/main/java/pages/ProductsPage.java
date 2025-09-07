package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	// **************** Locators **************** //
	By productsLink = By.xpath("//a[contains(text(),'Products')]");
	By categoryWomen = By.xpath("//a[normalize-space()='Women']");
    By subCategoryDress = By.xpath("//a[normalize-space()='Dress']");
    By searchBar = By.id("search_product");
    By submitButton = By.id("submit_search");
    By firstViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        this.js = (JavascriptExecutor) driver;
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickProducts() {
    	//wait.until(ExpectedConditions.elementToBeClickable(productsLink));
    	driver.findElement(productsLink).click();
    }
    
    public void selectCategory() {
    	//wait.until(ExpectedConditions.elementToBeClickable(categoryWomen));
    	driver.findElement(categoryWomen).click();
    }
    
    public void selectSubCategory() {
    	wait.until(ExpectedConditions.elementToBeClickable(subCategoryDress));
    	driver.findElement(subCategoryDress).click();
    }
    
    public void scrollDown() {
    	js.executeScript("window.scrollBy(0,300)");
    }
    
    public void viewFirstProduct() {
    	wait.until(ExpectedConditions.elementToBeClickable(firstViewProduct));
    	driver.findElement(firstViewProduct).click();
    }
    
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
    
    public void searchBarText(String search) {
        driver.findElement(searchBar).sendKeys(search);
    }
    
    public void clickSearchButton() {
        driver.findElement(submitButton).click();
    }
    
    /*public void scrollUp() {
    	wait.until(ExpectedConditions.elementToBeClickable(scrollUpLink));
    	driver.findElement(scrollUpLink).click();
    }*/

    

}
