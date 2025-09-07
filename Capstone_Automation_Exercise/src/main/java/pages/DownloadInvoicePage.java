package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadInvoicePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// **************** Locators **************** //
	By downloadInvoiceButton = By.xpath("//a[text()='Download Invoice']");

    public DownloadInvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
    }
    // **************** Actions **************** //
    public void openUrl(String url) {
        driver.get(url);
    }
    
    public void clickDownloadInvoice() {
    	driver.findElement(downloadInvoiceButton).click();
    }

    

}
