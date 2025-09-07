package tests;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DownloadInvoicePage;
import utils.ConfigReader;

public class DownloadInvoicePageTest {

    private WebDriver driver;
    private DownloadInvoicePage downloadInvoicePage;
    private ChromeOptions options;

    @BeforeClass
    public void setUp() {
        ConfigReader.loadProperties();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "C:\\ProgramData\\Jenkins\\Downloads");
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);

        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        downloadInvoicePage = new DownloadInvoicePage(driver);
        downloadInvoicePage.openUrl(ConfigReader.getProperty("downloadInvoiceUrl"));
    }

    // download invoice
    @Test(priority = 1)
    public void downloadInvoiceTest() throws InterruptedException {
        downloadInvoicePage.clickDownloadInvoice();
        Thread.sleep(3000);

        String downloadPath = "C:\\ProgramData\\Jenkins\\Downloads";
        File downloadedFile = new File(downloadPath + "\\invoice.txt");

        Assert.assertTrue(downloadedFile.exists(), "Invoice file was not downloaded!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
