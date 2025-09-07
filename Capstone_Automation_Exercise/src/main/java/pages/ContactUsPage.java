package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactUsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// **************** Locators **************** //
	By contactName = By.name("name");
	By contactEmail = By.name("email");
	By contactSubject = By.name("subject");
	By contactMessage = By.name("message");
	By contactSubmit = By.xpath("//input[@type='submit' and @value='Submit']");
	
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
    }
    
    public void enterName(String name) {
    	driver.findElement(contactName).sendKeys(name);
    }
    public void enterEmail(String email) {
    	driver.findElement(contactEmail).sendKeys(email);
    }
    public void enterSubject(String subject) {
    	driver.findElement(contactSubject).sendKeys(subject);
    }
    public void enterMessage(String message) {
    	driver.findElement(contactMessage).sendKeys(message);
    }
    public void clickSubmit() {
    	driver.findElement(contactSubmit).click();
    }
    public void handleAlert() {
    	Alert alert = driver.switchTo().alert();
    	System.out.println("Alert message: " + alert.getText());
    	alert.accept();
    }
    

}
