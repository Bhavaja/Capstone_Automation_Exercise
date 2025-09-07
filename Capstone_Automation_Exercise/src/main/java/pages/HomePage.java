package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// **************** Locators **************** //
	By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
	By productsLink = By.xpath("//a[contains(text(),'Products')]");
    By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");
    By testCasesLink = By.xpath("//a[contains(text(),'Test Cases')]");
    By apiTestingLink = By.xpath("//a[contains(text(),'API Testing')]");
    By videoTutorialsLink = By.xpath("//a[contains(text(), 'Video Tutorials')]");

   
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
    }
    
    public void clickSignupLogin() {
    	//wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink));
        //element.click();
    	driver.findElement(signupLoginLink).click();
    }

    public void clickProducts() {
    	//wait.until(ExpectedConditions.elementToBeClickable(productsLink));
    	driver.findElement(productsLink).click();
    }

    public void clickCart() {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartLink));
    	driver.findElement(cartLink).click();   
    }

    public void clickContactUs() {
    	//wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
    	driver.findElement(contactUsLink).click();
    }

    public void clickTestCases() {
    	//wait.until(ExpectedConditions.elementToBeClickable(testCasesLink));
    	driver.findElement(testCasesLink).click();
    }

    public void clickApiTesting() {
    	//wait.until(ExpectedConditions.elementToBeClickable(apiTestingLink));
    	driver.findElement(apiTestingLink).click();
    }
  

}
